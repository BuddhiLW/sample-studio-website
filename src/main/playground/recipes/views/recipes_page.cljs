(ns playground.recipes.views.recipes-page
  (:require
   ["@mui/material" :refer [Grid Box Typography Button]]
   [playground.auth.subs]
   [playground.components.page-nav :refer [page-nav]]
   [playground.recipes.subs]
   [playground.recipes.views.recipe-editor :refer [recipe-editor]]
   [playground.recipes.views.recipe-list :refer [recipe-list]]
   [re-frame.core :as rf]))

(defn recipes-page
  []
  (fn []
    (let [drafts @(rf/subscribe [:filter/draft])]
      [:> Grid {:flex-grow 3}
       [page-nav {:center "Profissionais"}]
       [:> Grid {:display "flex"
                 :flex-direction "column"
                 :container true}
        (when (seq drafts)
          [:> Box
           [:<>
            [:> Typography {:text-align "left"
                            :component "h2"
                            :variant "h2"
                            :pb 5
                            :pl 5
                            :font-weight 700}
             "Drafts"]
            [recipe-list drafts]]])
        [:<>
         [:> Grid {:container true
                   :mb 5
                   :ml {:xs 0
                        :sm 3
                        :md 5}
                   :row-spacing {:xs 1
                                 :sm 2
                                 :md 3}
                   :flex-direction "column"
                   :sx {:display "flex"
                        :flex-wrap "wrap"
                        :align-items "strech"}}
            [recipe-list (vals @(rf/subscribe [:recipes]))]]]]])))
