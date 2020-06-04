import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)
export default new Vuex.Store({
    state:{
        token:''
    },
    mutations:{
        changeToken(state,str){
            state.token = str;
        },
        exit(state){
            state.token = '';
        }
    }
})