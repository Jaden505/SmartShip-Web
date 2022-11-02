/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./index.html",
    "./src/**/*.{vue,js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        'regular-blue': '#0061FF',
        'light-blue': "#60EFFF",
        'light-text': "#E0E1DD",
        'dark-blue': "#00111C"
      }
    },
  },
  plugins: [],
}