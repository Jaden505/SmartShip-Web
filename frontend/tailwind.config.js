/** @type {import('tailwindcss').Config} */
module.exports = {
  darkMode: "class",
  content: [
    "./index.html",
    "./src/**/*.{vue,js,ts,jsx,tsx}",
  ],
  variants: {
    extend: {
      visibility: ["group-hover"],
    }
  },
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
          'light': '#60EFFF',
          'lavender': '#ebf2fa'
        },
        purple: {
          'basic': '#D6E8FA',
          'dark': '#B9D7F6',
          'light': '#D3E6F9'
        },
        white: {
          'text': '#E0E1DD',
          'disabled': '#898A86',
          'basic': '#ffffff'
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
