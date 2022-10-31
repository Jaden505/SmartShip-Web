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
        blue: {
          'regular': '#0061FF',
          'light': "#60EFFF",
          'dark': "#00111C",
          'card-blue': '#002C48',
          'light-card': '#15415E'
        },
        white: {
          'text': '#E0E1DD',
          'disabled': '#898A86'
        },
        red: {
          'regular': '#FF0707',
          'pink': '#FF00D5'
        },

      }
    },
  },
  plugins: [],
}