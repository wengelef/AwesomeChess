<template>
  <div class="chessboard">
    <h1>{{ $store.state.value }}</h1>
    <textarea
        v-model="command"
        placeholder="input command"
        rows="1"></textarea>
    <button v-on:click="send">Send</button>

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
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
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
