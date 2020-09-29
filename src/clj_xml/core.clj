(ns clj-xml.core
  (:require [clojure.data.xml :as clj-xml]
            [clojure.xml :as xml])
  (:gen-class))

(def bookshelf
  (clj-xml/element :books {}
               (clj-xml/element :book {:author "Stuart Halloway"}
                            "Programming Clojure")
               (clj-xml/element :book {:author "Christian Queinnec"}
                            "Lisp in Small Pieces")
               (clj-xml/element :book {:author "Harold Abelson, Gerald Jay Sussman"}
                            "Structure and Interpretation of Computer Programs")))

(def enlive-tree-normalized-nonblank
  {:tag     :foo,
   :attrs   {},
   :content [{:tag :name, :attrs {}, :content ["John"]}
             {:tag :address, :attrs {}, :content ["1 hacker way"]}
             {:tag :phone, :attrs {}, :content []}
             {:tag     :school,
              :attrs   {},
              :content [{:tag :name, :attrs {}, :content ["Joe"]}
                        {:tag :state, :attrs {}, :content ["CA"]}
                        {:tag :type, :attrs {}, :content ["FOOBAR"]}]}
             {:tag     :college,
              :attrs   {},
              :content [{:tag :name, :attrs {}, :content ["mit"]}
                        {:tag :address, :attrs {}, :content []}
                        {:tag :state, :attrs {}, :content ["Denial"]}]}]})

 


(defn -main [input output]
  (with-open [r (clojure.java.io/input-stream input)] 
    (let [oi (xml/parse r)]
      (println oi)
      (with-open [w (clojure.java.io/writer output)]
        (.write w (clj-xml/indent-str oi)))
      )))
