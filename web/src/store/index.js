import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

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
    }
});
