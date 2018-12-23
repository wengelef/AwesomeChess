<template>
  <div class="chessboard">
    <h1>{{ $store.state.value }}</h1>

    <md-card md-with-hover>
      <!--<md-field>
        <label>Send commands</label>
        <md-input v-model="command"></md-input>
      </md-field>-->
      <md-card-actions>
        <md-button @click="start">Start</md-button>
        <md-button @click="turn">Turn</md-button>
        <md-button @click="board">Board</md-button>
        <md-button @click="test">Test</md-button>
      </md-card-actions>

    </md-card>

    <table class="board">
        <tr v-for="(row, rowIndex) in $store.state.board" :key="rowIndex">
            <td v-for="(col, colIndex) in row" :key="colIndex">
                <div>
                    <img :src="getAssetUrl(col.team, col.piece)" alt="">
                </div>
            </td>
        </tr>
    </table>
  </div>
</template>

<script>
import store from '../socketStore'
import { mapActions } from 'vuex'

import 'vue-material/dist/vue-material.min.css'

export default {
  name: 'Main',
  store,
  data () {
    return {
      command: ''
    }
  },
  methods: {
    ...mapActions({
      send (context) {
        const text = this.command
        context('send', { text })
        this.command = ''
      },
      start (context) {
        context('sendStart')
      },
      turn (context) {
        context('sendTurn')
      },
      board (context) {
        context('sendBoard')
      },
      test (context) {
        context('sendTest')
      }
    }),
    getAssetUrl (team, piece) {
      var images = require.context('../assets/96px', false, /\.png$/)
      return images('./icons8-' + piece + '-' + team + '.png')
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

.md-field {
  width: 70%;
  margin-left: auto;
  margin-right: auto;
}

.md-card {
    margin: 4px;
    padding: 4px;
    display: inline-block;
    vertical-align: top;
  }

table.board {
  margin-left: auto;
  margin-right: auto;
}

#chessboard {
  margin-left:auto;
  margin-right:auto;
  vertical-align: middle;
  margin: auto;
}

tr:nth-child(even) td:nth-child(even), tr:nth-child(odd) td:nth-child(odd) {
  background: grey;
}
tr:nth-child(odd) td:nth-child(even), tr:nth-child(even) td:nth-child(odd) {
  background: white;
}

</style>
