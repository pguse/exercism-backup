(ns squeaky-clean
  (:require [clojure.string :as str]))

(defn clean
  [s]
      (-> s
          (str/replace #"\s" "_")
          (str/replace #"\p{Cc}" "CTRL")
          (str/replace #"-(\p{L})" #(str/upper-case (%1 0)))
          (str/replace #"[^\p{L}_]|[α-ω]" ""))
  )