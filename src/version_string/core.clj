(ns version-string.core
  (:require [clojure.edn :as edn]
            [clojure.string :refer [replace-first]]
            [instaparse.core :as insta]))

(def words-and-numbers
  "Parser for string to decompose words and numbers."
  (insta/parser
    "sentence = token (<whitespace>? token)*
     <token> = word | number
     whitespace = #'\\s+'
     word = #'[^0-9\\s]+'
     number = #'[0-9]+'"))

(defn version-vector
  "Decompose string with words and numbers."
  [s]
  (->> (words-and-numbers s)
       (insta/transform {:word identity
                         :number (comp #(or % 0)
                                       edn/read-string
                                       #(replace-first % #"^0+" ""))
                         :sentence vector})))

(defn sort-by-version
  "Sort the sequence of strings with numerical order."
  [seq]
  (sort-by version-vector seq))
