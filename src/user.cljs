(ns user
  (:require [meander.epsilon :as m]
            [com.fulcrologic.guardrails.core :refer [>defn =>]]))


;; https://cljdoc.org/d/meander/epsilon/0.0.588/doc/operator-overview#unquote
(>defn match-my-map
  [m x]
  [map? int? => vector?]
  (m/match m
    {:x ~x :y ?y}
    [:okay ?y]

    _
    [:fail]))


(comment
  (match-my-map {:x 1, :y 2} 1))


(defn -main
  [& xs]
  (doseq [x xs]
    (println x "-" (pr-str (match-my-map {:x 1, :y 2} (js/parseInt x))))))
