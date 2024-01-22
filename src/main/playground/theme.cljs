(ns playground.theme
  (:require
   [clojure.string :as string]
   ["@mui/material/styles" :refer [createTheme]]))

(def theme (createTheme
            (clj->js
             {:typography {:fontFamily (string/join ","
                                                    ["Playfair Display"])}
              :palette
               {:primary
                {:main "#0B1A2F"
                 :black "#130905"
                 :primary "#27AB83"
                 :secondary "#F7D070"
                 :light "#D9E2EC"
                 :dark "#2F3FFF"
                 :white "#FFFAFA"
                 :form "#F8F8FF"
                 :main-background "#FFFAFA"
                 :borderRadius "20px"
                 :borderRadiusSm "10px"
                 :borderRadiusLg "18px"
                 :modalHeaderBorderColor "white"}}
               {:secondary
                {:main "#651fff"
                 :light "#0066ff"
                 :dark "#ff5500"
                 :contrastText "#ffcc00"}}
               {:tertiary
                {:main "#e91e63"}}
               {:card-title
                {:main "#FFEFEF"}}
               {:card-title
                {:main "#FFEFEF"}}})))
               

(def buttons (createTheme
              (clj->js
               {:components
                {:MuiButton
                 {:styleOverrides
                  {:root
                   {:primary "#ff002b"
                    :font-size "1.2rem"}}}}})))
;; #ff00aa
;; #00ff55
;; #d400ff
;; #ff002b
;; #ff5500
;; #aaff00

(def nav (createTheme
          (clj->js
           {:components
            {:MuiTypography
             {:styleOverrides
              {:root
               {:breakpoints
                 {:xs
                  {:font-size "1rem"}
                  :sm
                  {::font-size "1.2rem"}
                  :md
                  {::font-size "1.4rem"}}}}}}
            :palette
            {:primary
             {:main "#596469"
              :secondary "#FFFAFA"
              :tertiary "#F0EBE3"}}})))

(def cards (createTheme
            (clj->js
             {:palette
              {:primary
                {:main "#3A3F3F"
                 :light "#FFFAFA"}}})))


(def footer-theme (createTheme
                   (clj->js
                    {:components
                     {:MuiTypography
                      {:styleOverrides
                       {:root
                        {:font-size "1.2rem"}}}}
                     :palette
                     {:primary
                      {:main "#6F7071"
                       :contrast "#383F4C"
                       :main-background "#000000"
                       :tertiary "#4433FF"}}})))

