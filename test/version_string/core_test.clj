(ns version-string.core-test
  (:require [clojure.test :refer :all]
            [version-string.core :refer :all]))

(def source
  '["vm-10.0.0.tar.gz"
    "vm-1.0.0.tar.gz"
    "vm-2.0.070.tar.gz"
    "vm-2.0.080.tar.gz"
    "vm-2.0.60.tar.gz"])
(def sorted
  '["vm-1.0.0.tar.gz"
    "vm-2.0.60.tar.gz"
    "vm-2.0.070.tar.gz"
    "vm-2.0.080.tar.gz"
    "vm-10.0.0.tar.gz"])

(deftest a-test
  (testing "sort"
    (is (= (sort-by-version source)
           sorted)))
  (testing "decompose"
    (is (= (version-vector "vm-10.090.0.tar.gz")
           ["vm-" 10 "." 90 "." 0 ".tar.gz"]))))
