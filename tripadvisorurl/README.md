# tripadvisorurl

A Clojure library designed to fetch all hotel urls of city.

## Usage
user> (tripadvisorurl.core/go-to-tripadv-api "Varanasi")

"https://www.tripadvisor.in/Hotels-g297685-Varanasi_Uttar_Pradesh-Hotels.html"

user> (tripadvisorurl.core/fetch-all-nav-urls (tripadvisorurl.core/go-to-tripadv-api "Varanasi"))

("https://www.tripadvisor.in/Hotels-g297685-Varanasi_Uttar_Pradesh-Hotels.html" "https://www.tripadvisor.in/Hotels-g297685-oa30-Varanasi_Uttar_Pradesh-Hotels.html" "https://www.tripadvisor.in/Hotels-g297685-oa60-Varanasi_Uttar_Pradesh-Hotels.html")

user> (tripadvisorurl.core/parse-hotel-url "https://www.tripadvisor.in/Hotels-g297685-Varanasi_Uttar_Pradesh-Hotels.html")

(["The Gateway Hotel Ganges Varanasi" "/Hotel_Review-g297685-d304796-Reviews-The_Gateway_Hotel_Ganges_Varanasi-Varanasi_Uttar_Pradesh.html"] ["Ramada Plaza JHV Varanasi" "/Hotel_Review-g297685-d626936-Reviews-Ramada_Plaza_JHV_Varanasi-Varanasi_Uttar_Pradesh.html"] ["Hotel Alka" "/Hotel_Review-g297685-d652869-Reviews-Hotel_Alka-Varanasi_Uttar_Pradesh.html"] ["The Gateway Hotel Ganges Varanasi" "/Hotel_Review-g297685-d304796-Reviews-The_Gateway_Hotel_Ganges_Varanasi-Varanasi_Uttar_Pradesh.html"] ["Hotel Buddha" "/Hotel_Review-g297685-d1022189-Reviews-Hotel_Buddha-Varanasi_Uttar_Pradesh.html"] ["Radisson Hotel Varanasi" "/Hotel_Review-g297685-d307335-Reviews-Radisson_Hotel_Varanasi-Varanasi_Uttar_Pradesh.html"] ["Hotel Heritage Inn & Zo Rooms" "/Hotel_Review-g297685-d3270634-Reviews-Hotel_Heritage_Inn_Zo_Rooms-Varanasi_Uttar_Pradesh.html"] ["Hotel Surya" "/Hotel_Review-g297685-d811033-Reviews-Hotel_Surya-Varanasi_Uttar_Pradesh.html"] ["Hotel Janki International & ZO Rooms" "/Hotel_Review-g297685-d7332301-Reviews-Hotel_Janki_International_ZO_Rooms-Varanasi_Uttar_Pradesh.html"] ["Ganpati Guest House" "/Hotel_Review-g297685-d609694-Reviews-Ganpati_Guest_House-Varanasi_Uttar_Pradesh.html"] ["Rivatas by Ideal" "/Hotel_Review-g297685-d3668358-Reviews-Rivatas_by_Ideal-Varanasi_Uttar_Pradesh.html"] ["A Palace on the River, Rashmi Guest House" "/Hotel_Review-g297685-d596275-Reviews-A_Palace_on_the_River_Rashmi_Guest_House-Varanasi_Uttar_Pradesh.html"] ["Hotel Ganesha" "/Hotel_Review-g297685-d2014778-Reviews-Hotel_Ganesha-Varanasi_Uttar_Pradesh.html"] ["Hotel Vibhav Harsh" "/Hotel_Review-g297685-d2398143-Reviews-Hotel_Vibhav_Harsh-Varanasi_Uttar_Pradesh.html"] ["Shiva Ganges View" "/Hotel_Review-g297685-d660423-Reviews-Shiva_Ganges_View-Varanasi_Uttar_Pradesh.html"] ["Hotel Gupta Inn" "/Hotel_Review-g297685-d1903588-Reviews-Hotel_Gupta_Inn-Varanasi_Uttar_Pradesh.html"] ["Hotel Central Residency" "/Hotel_Review-g297685-d3385195-Reviews-Hotel_Central_Residency-Varanasi_Uttar_Pradesh.html"] ["Hotel Varuna" "/Hotel_Review-g297685-d3179521-Reviews-Hotel_Varuna-Varanasi_Uttar_Pradesh.html"] ["Suryauday Haveli - An Amritara Resort" "/Hotel_Review-g297685-d2144981-Reviews-Suryauday_Haveli_An_Amritara_Resort-Varanasi_Uttar_Pradesh.html"] ["WelcomHeritage Jukaso Ganges" "/Hotel_Review-g297685-d2559193-Reviews-WelcomHeritage_Jukaso_Ganges-Varanasi_Uttar_Pradesh.html"] ["Hotel Temple on Ganges" "/Hotel_Review-g297685-d647183-Reviews-Hotel_Temple_on_Ganges-Varanasi_Uttar_Pradesh.html"] ["Gautam Hotel" "/Hotel_Review-g297685-d1157374-Reviews-Gautam_Hotel-Varanasi_Uttar_Pradesh.html"] ["Ajay Guest House" "/Hotel_Review-g297685-d624704-Reviews-Ajay_Guest_House-Varanasi_Uttar_Pradesh.html"] ["Hotel Haifa & Zo Rooms" "/Hotel_Review-g297685-d649265-Reviews-Hotel_Haifa_Zo_Rooms-Varanasi_Uttar_Pradesh.html"] ["Cresent Villa" "/Hotel_Review-g297685-d1632528-Reviews-Cresent_Villa-Varanasi_Uttar_Pradesh.html"] ["Hotel Meraden Grand" "/Hotel_Review-g297685-d730072-Reviews-Hotel_Meraden_Grand-Varanasi_Uttar_Pradesh.html"] ["Hotel Grapevine" "/Hotel_Review-g297685-d7933873-Reviews-Hotel_Grapevine-Varanasi_Uttar_Pradesh.html"] ["Hotel Clarks Varanasi" "/Hotel_Review-g297685-d478847-Reviews-Hotel_Clarks_Varanasi-Varanasi_Uttar_Pradesh.html"] ["Palace on Steps" "/Hotel_Review-g297685-d680885-Reviews-Palace_on_Steps-Varanasi_Uttar_Pradesh.html"] ["Diamond Hotel" "/Hotel_Review-g297685-d507608-Reviews-Diamond_Hotel-Varanasi_Uttar_Pradesh.html"] ["Hotel Plaza Inn" "/Hotel_Review-g297685-d1157412-Reviews-Hotel_Plaza_Inn-Varanasi_Uttar_Pradesh.html"])

## License

Copyright © 2016 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
