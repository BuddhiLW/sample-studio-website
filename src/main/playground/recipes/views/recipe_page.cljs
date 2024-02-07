(ns playground.recipes.views.recipe-page
  (:require
   ["@mui/material" :refer [Button Grid Typography]]
   [playground.components.page-nav :refer [page-nav]]
   [playground.nav.subs]
   [playground.recipes.views.publish-recipe :refer [publish-recipe]]
   [playground.recipes.views.recipe-editor :refer [recipe-editor]]
   [playground.recipes.views.recipe-info :refer [recipe-info]]
   [playground.recipes.views.recipe-steps :refer [recipe-steps]]
   [playground.recipes.views.request-to-cook :refer [request-to-cook]]
   [playground.router :as router]
   [playground.utilites :as util]
   [re-frame.core :as rf]
   [playground.gallery.views.gallery :refer [gallery]]))

(defn recipe-page
  []
  (fn []
    (let [recipe @(rf/subscribe [:recipes/recipe])
          active-nav @(rf/subscribe [:active-nav])
          {:keys [name]} recipe]
      [:<>
       [page-nav {:left (if (active-nav :saved)
                          :saved
                          :recipes)
                  :center [:> Typography {:variant "div"
                                          :color "inherit"
                                          :py 5
                                          :justify-content "center"
                                          :font-size "2.5rem"
                                          :font-weight 700}
                           name]}]
       [:> Grid {:container true
                 :width "100vw"
                 :sx {:flex true
                      :justify-content "space-between"
                      :direction {:sx "column"
                                  :xs "row"
                                  :sm "row"
                                  :md "row"}
                      :my 3}}
        [:> Grid {:item true
                  :xs 12
                  :sm 5
                  :columns {:xs 6
                            :sm 7
                            :md 12}
                  :justify-content {:sx "center"
                                    :xs "center"}
                  :px 2
                  :py 2}
         [recipe-info]]
        [:> Grid {:xs 12
                  :sm 6
                  :item true
                  :sx {:mx {:xs 1}
                       :my {:xs 0
                            :sm 2}
                       :min-width "300px"}}
         [gallery]]]])))

