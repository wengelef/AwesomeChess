import Vue from 'vue'
import VueNativeSock from 'vue-native-websocket'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    count: 0,
    socket: {
      isConnected: false,
      message: '',
      reconnectError: false
    },
    value: '',
    board: [8][8]
  },
  mutations: {
    SOCKET_ONOPEN (state, event) {
      state.socket.isConnected = true
      console.log('Connected')
    },
    SOCKET_ONCLOSE (state, event) {
      state.socket.isConnected = false
      console.log('Disconnected')
    },
    SOCKET_ONERROR (state, event) {
      console.log('Socket Error')
    },
    SOCKET_ONMESSAGE (state, any) {
      let {sender, message} = any
      console.log('onMessage from [' + sender + '] with ' + message)
      state.message = any
    },
    [WebSocket.WS_RECONNECT] (state, count) {
      console.info(state, count)
    },
    [WebSocket.WS_RECONNECT_ERROR] (state) {
      state.socket.reconnectError = true
    },
    increment (state) {
      state.count++
    }
  },
  actions: {
    message (context, data) {
      let {message} = data
      this.state.value = message
    },
    board (context, data) {
      let {message} = data
      this.state.board = message
    },
    send: ({ commit }, message) => {
      Vue.prototype.$socket.sendObj({command: message.text})
    },
    sendStart: ({ commit }) => {
      Vue.prototype.$socket.sendObj({command: 'start'})
    },
    sendBoard: ({ commit }) => {
      Vue.prototype.$socket.sendObj({command: 'board'})
    },
    sendTurn: ({ commit }) => {
      Vue.prototype.$socket.sendObj({command: 'turn'})
    },
    sendTest: ({ commit }) => {
      Vue.prototype.$socket.sendObj({command: 'test'})
    }
  }
})

Vue.use(VueNativeSock, 'ws://192.168.0.101:8080', { store: store, format: 'json' })

export default store
