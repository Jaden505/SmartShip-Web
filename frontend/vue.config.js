const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  devServer: {
    port: 8080,
    proxy: "http://localhost:8085/api"
  },
  transpileDependencies: true
})

module.exports = {
  devServer: {
    port: 8081
  }
}
