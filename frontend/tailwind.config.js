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
          'regular': '#29acda',
          'light': "#60EFFF",
          'dark': "#141419",
          'card-blue': '#202020',
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
        gray: {
          'unselected': '#898A86'
        }
      }
    },
  },
  plugins: [],
}