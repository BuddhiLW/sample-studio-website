(ns playground.gallery.views.gallery
  (:require
   ["@mui/material" :refer [Box Button Grid Typography]]
   [playground.components.page-nav :refer [page-nav]]
   [playground.router :as router]
   [re-frame.core :as rf]
   [reagent.core :as r]))

(defn item
  [src chosen]
  [:div
   [:img {:class "rounded-lg snap-center"
          :src src
          :on-click #(swap! chosen assoc :src src)}]])

(defn gallery
  []
  (let [initial-value {:src "https://flowbite.s3.amazonaws.com/docs/gallery/square/image-3.jpg"}
          chosen (r/atom initial-value)]
      (fn []
       [:<>
        [:div {:class "grid gap-4"}
         [:div {:class "mx-auto"}
          [:img {:class "h-auto max-w-full rounded-lg rounded-lg"
                 :src (:src @chosen)}]]
         [:div {:class "grid grid-cols-4 gap-4"} ;;
          (let [items ["https://flowbite.s3.amazonaws.com/docs/gallery/square/image-1.jpg"
                       "https://flowbite.s3.amazonaws.com/docs/gallery/square/image-2.jpg"
                       "https://flowbite.s3.amazonaws.com/docs/gallery/square/image-3.jpg"
                       "https://flowbite.s3.amazonaws.com/docs/gallery/square/image-4.jpg"
                       "https://flowbite.s3.amazonaws.com/docs/gallery/square/image-5.jpg"]]
             (for [src items]
               [item src chosen]))]]])))

(defn gallery-page
  []
  [:> Grid {:container true
            :display "flex"
            :flex-direction "collumn"
            :justify-content "center"
            :align-items "flex-start"
            :sx {:height {:xs "80vh"
                          :sm "110vh"
                          :md "130vh"
                          :lg "150vh"
                          :xl "150vh"}
                 :overflow-y "scroll"
                 :width {:xs "100vw"}
                 :mb {:xs 1
                      :sm 3}}}
   [page-nav {:center "Nossos Serviços"}]
   [:> Grid {:sx {:mx {:xs 1
                       :sm 4
                       :md "10%"
                       :lg "13%"
                       :xl "20%"}
                  :min-width "300px"}}
    [gallery]]])
