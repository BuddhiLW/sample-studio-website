(ns playground.components.page-nav
  (:require
   ["@mui/icons-material/Adjust" :default AdjustIcon]
   ;; ["@mui/icons-material/ChevronLeft" :default ChevronLeftIcon]
   ["@mui/icons-material/ArrowCircleLeftRounded" :default ArrowCircleLeftRoundedIcon]
   ["@mui/material" :refer [Box Button Grid Typography  colors Avatar]]
   [playground.router :as router]))

(defn page-nav
  [{:keys [left center right]}]
  [:<>
   [:> Box {:py {:xs 1}
            :px 5
            :component "nav"
            :variant "dense"
            :fluid "false"
            :display "flex"
            :container "true"
            :align-items "center"
            :sx {:width "100%"
                 :height {:xs "10rem"
                          :sm "15rem"
                          :md "20rem"}
                 :justify-content {:sm "start"
                                   :md "space-between"}}}
    [:> Box {:display "flex"
             :justify-content "flex-start"
             :py 1}
     (if left
       [:> Button {:my {:xs 1
                        :sm 2
                        :md 20}
                   :variant "light"
                   :aria-label "Back"
                   :href (router/path-for left)}
         [:> ArrowCircleLeftRoundedIcon {:sx {:font-size "2.5rem"
                                              :color (get-in (js->clj colors :keywordize-keys true) [:pink :500])}}]]
       "")]
    [:> Box {:justify-content "center"
             :opacity 1}
     (if (= (type center) (type "String"))
       [:> Typography {:variant "h1"
                       :font-style "italic"
                       :font-family "serif"
                       :color "inherit"
                       :py 5
                       :font-weight 400
                       :sx {:font-size {:xs "3rem"
                                        :md "6rem"}}}
        center]
       center)]
    [:> Box
     (cond
       (= (type right) (type "String"))  [:> Box {:display "flex"
                                                  :justify-content "flex-end"
                                                  :py 1}
                                          right]
       (nil? right)                      [:div " "]
       :else                             right)]]])
