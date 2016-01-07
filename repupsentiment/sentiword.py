#!/usr/bin/python
# coding utf-8
import re
from rake.rake import Rake
import pattern
from pattern import text
from vaderSentiment.vaderSentiment import sentiment
import itertools
from itertools import chain
import json
from langdetect import detect

rakeobj = Rake('/Users/mukeshtiwari/Programming/Code/Puzzles/Semanticanalsys/sentimentengine/requesthandler/repupsentiment/stopwords/SmartStoplist.txt', 3, 3, 1)

#clean data. remove punctuation
def cleanData(review):
	repdot = re.sub("\.{1,}|!{1.}", ". ", review)
	return re.sub("[^.a-zA-Z0-9]", " ", repdot).lower()

def predicate(t):
	return t[1] == 'NN' or t[1] == 'NNS' #or t[1] == 'JJ' or t[1] == 'JJS' or t[1] == 'JJR'

def processSentiment(senti):
	val = senti["compound"]
	if val < 0: return "Negative"
	elif val > 0: return "Positive"
	else: return "Neutral"

def processKeyword(keylist):
     #return ', '.join(keylist)
     return ', '.join(filter (None, map (lambda t: ' '.join(map (lambda w: w[0], filter (predicate, list(itertools.chain.from_iterable (map (text.tag, t.split())))))), keylist)))

def jsondata(sentence):
      #figure out if sentence contains but 
      sentlist = sentence.split('but')
      return {'sentence' : sentence, 'sentiment' : processSentiment(sentiment(sentence)), 
	      'data' : [{'rel' : 'nmod', 
		      'phrase' : [{'value' : t, 'sentiment' : processSentiment(sentiment(t)), 'index' : [0, 10], 
			           'keyword' : processKeyword(map (lambda x : x[0], rakeobj.run(t)))} for t in sentlist]}]}  

def findkeyword(cdata):
      ldata = text.tokenize(cdata)
      return json.dumps({'review' : cdata,'reviewData' : [jsondata(rev) for rev in ldata]})

def filterPattern(review):
      cdata = cleanData(review)
      try:
      	if(detect(cdata) == 'en'): return findkeyword(cdata)
      	else: return json.dumps({'review' : review, 'reviewData' : []})
      except:
	      return json.dumps({'review' : review, 'reviewData' : []})

