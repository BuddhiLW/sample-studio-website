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
   [:> Card {:sx {:height {:xs "120vh"
                           :sm "95vh"}}}
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
                 :mb {:xs 1
                      :sm 3}
                 :mt {:xs 1
                      :sm 3}
                 :display "flex"
                 :sx {:height {:xs "100%"}
                      :display {:xs "flex"}
                      :flex-direction {:xs "column"
                                       :md "row"}
                      :justify-content {:xs "center"
                                        :md "center"}
                      :align-items {:xs "left"
                                    :md "center"}}}
        [:> Grid {:item true
                  ;; :xs 6
                  :md 6
                  :lg 4
                  ;; :m
                  ;; :mt 3}
                  :display {:md "flex"}
                  :justify-content {:md "center"}
                  :align-items {:md "center"}}
         [:img  {:fit "contain"
                 :src "/img/Fotos-Estudio/tatuadores/logo.jpg"
                 :class-name "rounded-full"
                 :alt "Hand holding a cup of coffee"}]]
        [:> Grid {:item true
                  ;; :xs 6
                  :md 8
                  ;; :md 6
                  :pr {:md "0.2em"
                       :lg "5rem"
                       :xl "30em"}}
                  ;; :sx {;;:flex-direction "column"
                  ;;      ;; :xs {:px "1rem"}
                  ;;      :display "flex"}}
                       ;; :justify-content "flex-end"}}
         [:> CardContent {:variant "body2"
                          :sx {:max-width {:xs "95vw"
                                           :md "100%"}}}
          [:> Box {:sx {:bgcolor "primary.light"
                        :box-shadow 1
                        :border-radius 2
                        :px 2
                        :pb 2
                        :pt 1
                        :mx "auto"}}
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
