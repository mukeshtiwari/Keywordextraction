(ns tripadvisorurl.core
  (:require [clj-webdriver.taxi :refer :all]
            [net.cgrand.enlive-html :as ehtml]
            [clj-json.core :as json]))


(defn rest-url-from-page [url page-no]
  (let [[f-el s-el t-el] (clojure.string/split url #"-" 3)
        all-page-no
        (map (fn [x] (str "oa" (* 30 x))) (rest (range page-no)))
        final-url
        (map (fn [x] (str f-el "-" s-el "-" x "-" t-el)) all-page-no)] final-url))


(defn fetch-all-nav-urls
  "fetch all the tripadvisor navigation urls for a city"
  [url]
  (as-> (java.net.URL. url) d
    (ehtml/html-resource d)
    (ehtml/select d [:div.pageNumbers :a])
    (last d)
    (first (:content d))
    (cons url
          (if (nil? d) nil
              (rest-url-from-page url (Integer/valueOf d))))))

;some thing went wrong with my firefox update
(defn go-to-tripadv
  "returns tripadvisors urls for city"
  [city]
  (do
    (set-driver! {:browser :firefox})
    (get-url "https://www.tripadvisor.in")
    (wait-until #(= (title) "TripAdvisor: Read Reviews, Compare Prices & Book"))
    (input-text "#GEO_SCOPED_SEARCH_INPUT" city)
    (click "#GEO_SCOPE_CONTAINER .scopedSearchDisplay li")
    (apply quick-fill-submit
           [{"#mainSearch" "Hotel"}
            {"#SEARCH_BUTTON" click}])
    (wait-until
     #(not= (title) "TripAdvisor: Read Reviews, Compare Prices & Book"))
    (let [home-url (current-url)
          page (page-source)
          rest-url (fetch-all-nav-urls page)]
      (quit)
      (cons home-url rest-url))))

(defn go-to-tripadv-api
  "Tripadvisor API for fetching JSON and extract url"
  [city]
  (as-> (str "https://www.tripadvisor.in/TypeAheadJson?query="
             city
             "&action=API&types=geo,theme_park&link_type=hotel&details=false") d
    (java.net.URL. d)
    (ehtml/html-resource d)
    (map (comp first :content first :content) d)
    (first d)
    (json/parse-string d)
    (get d "results")
    (first d)
    (get d "url")
    (str "https://www.tripadvisor.in" d)))

(defn parse-hotel-url
  "returns all the hotels from tripadvisor page"
  [url]
  (as-> (java.net.URL. url) d
    (ehtml/html-resource d)
    (ehtml/select d [:a.property_title])
    (map (juxt (comp first :content) (comp :href :attrs)) d)))
