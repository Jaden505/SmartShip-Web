/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./index.html",
    "./src/**/*.{vue,js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      fontFamily: {
        sans: ['Montserrat', 'sans-serif']
      },
      colors: {
        black: {
          'basic': '#151515',
          'light': '#202020',
        },
        blue: {
          'regular': '#29acda',
        },
        white: {
          'text': '#E0E1DD',
          'disabled': '#898A86'
        },
        red: {
          'regular': '#FF0707',
          'pink': '#FF00D5'
        }
      }
    },
  },
  plugins: [],
}