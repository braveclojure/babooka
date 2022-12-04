#!/usr/bin/env bb

(require '[babashka.fs :as fs])
(require '[clojure.edn :as edn])

(defn read-entries
  []
  (if (fs/exists? "entries.edn")
    (edn/read-string "entries.edn")
    []))

(defn add-entry
  [text]
  (let [entries (read-entries)]
    (conj entries
          {:timestamp (System/currentTimeMillis)
           :entry     text})))
