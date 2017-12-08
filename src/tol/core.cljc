(ns tol.core)


(defn ->int
  "Coerce a given `value` as integer. If the `value` is not a number, returns `nil`."
  [value]
  (when (->> value str (re-find #"^-?\d+$"))
    #?(:clj (Integer. value))
    #?(:cljs (js/parseInt value 10))))
