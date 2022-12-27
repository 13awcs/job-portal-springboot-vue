import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);
import VuexPersistence from 'vuex-persist'
export default new Vuex.Store({
    state: {
        numberTableRows: 0,
        recruiterId: '',
        username: '',
    },
    mutations: {
        updateNumberRow(state, data) {
            state.numberTableRows = data;
        },
        updateRecruiterId(state,data) {
            state.recruiterId = data;
        },
        updateUserName(state,data) {
            state.username = data;
        }
    },
    actions: {
        updateNumberRow(context, data) {
            context.commit("updateNumberRow", data);
        },
        updateRecruiterId(context,data) {
            context.commit("updateRecruiterId",data);
        },
        updateUserName(context,data) {
            context.commit("updateUserName",data);
        }
    },
    plugins: [new VuexPersistence().plugin]
});
