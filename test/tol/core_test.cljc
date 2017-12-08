(ns tol.core-test
  (:require
    #?(:clj [clojure.test :refer [are deftest testing]])
    #?(:cljs [cljs.test :refer-macros [are deftest testing]])
    [tol.core :as tol]))


(deftest ->int-test
  (testing "should return integer or nil"
    (are [expected value] (= expected (tol/->int value))

         1 1
         1 "1"
         -1 "-1"
         nil "-"
         nil "a"
         nil ""
         nil nil)))
