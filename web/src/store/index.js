import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);
import VuexPersistence from 'vuex-persist'
export default new Vuex.Store({
    state: {
        numberTableRows: 0
    },
    mutations: {
        updateNumberRow(state, data) {
            state.numberTableRows = data;
        }
    },
    actions: {
        updateNumberRow(context, data) {
            context.commit("updateNumberRow", data);
        }
    },
    plugins: [new VuexPersistence().plugin]
});
