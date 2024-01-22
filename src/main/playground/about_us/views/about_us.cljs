(ns playground.about-us.views.about-us
  (:require
   ["@mui/material" :refer [Box Card CardContent CardMedia Grid ThemeProvider
                            Typography Button Image]]
   [playground.components.page-nav :refer [page-nav]]
   [playground.router :as router]
   [playground.theme :refer [cards]]
   [re-frame.core :as rf]))
   ;; [playground.become-a-chef.views.agreement :refer [agreement]]
   ;; ["@mui/icons-material/CheckCircle" :default CheckCircleIcon]))

(defn about-us
  []
  [:> ThemeProvider {:theme cards}
   [:> Card {:sx {:height "90vh"}}
     [:> Box {:sx {:position "relative"
                   :height "100%"}}
      [:> CardMedia {:component "img"
                     :image "/img/fundo-sobre.jpg"
                     :sx {:height "100%"}}]
      [:> Box {:sx {:position "absolute"
                    :bgcolor "rgba(0, 0, 0, 0.54)"
                    :top 0
                    :left 0
                    :width "100%"
                    :height "100%"
                    :color "white"
                    :px "10px"}}
       [:> Grid {:container true
                 :direction "row"
                 :mb 3
                 :sx {:height "75vh"}}
        [:> Grid {:item true
                  :xs 6
                  :display "flex"
                  :justify-content "center"
                  :align-items "center"}
         [:img  {:fit "contain"
                 :class-name "rounded-full"
                 :src "/img/Fotos-Estudio/tatuadores/logo.jpg"
                 :alt "Hand holding a cup of coffee"}]]
        [:> Grid {:item true
                  :xs 6
                  :display "flex"
                  :sx {:flex-direction "column"}
                  :justify-content "flex-end"}
         [:> CardContent {:variant "body2"}
          [:> Box {:sx {:bgcolor "primary.light"
                        :max-width 700
                        :box-shadow 1
                        :border-radius 2
                        :px 2
                        :pb 2
                        :pt 1}}
           [:> Typography {:class "text-gray"
                           :variant "h2"
                           :mb 3
                           :color "text.primary"
                           :font-style "bold"}
            "Quem somos"]
           [:> Typography {:variant "p"
                           :font-size "1.3rem"
                           :color "text.secondary"}
            "Proin blandit nulla eu justo ornare pulvinar. Phasellus ornare, lectus at vehicula molestie, lacus tortor vulputate lectus, sit amet viverra urna sem eu felis. Quisque varius accumsan nisi, ut finibus lorem condimentum eu."]]]]]]]]])

;; [:img {:class "w-full h-full object-cover opacity-30"
;;        :src "/img/fundo-sobre.jpg"}]
