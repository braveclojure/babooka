(ns journal.utils
  (:require
   [babashka.fs :as fs]
   [clojure.edn :as edn]))

(def ENTRIES-LOCATION "entries.edn")

(defn read-entries
  []
  (if (fs/exists? ENTRIES-LOCATION)
    (edn/read-string (slurp ENTRIES-LOCATION))
    []))
