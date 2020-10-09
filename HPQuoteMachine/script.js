

document.addEventListener('DOMContentLoaded', () => {
  const getQuote = (url, callback) => {
      const callbackName = 'displayQuote'
      window[callbackName] = function(data) {
          delete window[callbackName]
          document.body.removeChild(script)
          callback(data)
      }

      const script = document.createElement('script')
      script.src =
          url + (url.indexOf('?') >= 0 ? '&' : '?') + 'callback=' + callbackName
      document.body.appendChild(script)
  }

  const displayQuote = (data) => {
      colorRandomizer();
      const currentQuote = data.quoteText;
      const currentAuthor = data.quoteAuthor;
      //add them to my html
      const text = document.querySelector('#quoteText')
      if (text) {
          text.innerHTML = currentQuote;
          const author = document.querySelector('#quoteAuthor');
          author.innerHTML = `- ${currentAuthor}`;
          const twitter = document.querySelector('#twitter-share-button');
          if (twitter) {
              twitter.setAttribute('href', 'https://twitter.com/intent/tweet?hashtags=quotes,Fcc&related=freecodecamp&text=' + encodeURIComponent('"' + currentQuote + '" ' + currentAuthor))
          }
      }
  }
      
      const colorRandomizer = () => {
  const myColors = ['#3498db', '#2ecc71', '#9b59b6', '#e74c3c', '#f1c40f'];
  const randomNum = Math.floor((Math.random()*myColors.length));

  const randomColor = myColors[randomNum];
  const bgs = document.querySelector('.randomBgColor');
  
  for(const bg of bgs){
  bg.setAttribute('style', `background-color: ${randomColor}`);}

  const fills = document.querySelectorAll('.randomFillColor');
  for (const fill of fills) {
      fill.setAttribute('style', `fill: ${randomColor}`);
  }
  
  const texts = document.querySelectorAll('.randomTxtColor');
        for (const text of texts) {
            text.setAttribute('style', `color: ${randomColor}`)
        }
}

let isRandomQuoteDisplayed = false;
if (typeof window !== 'undefined') {
    isRandomQuoteDisplayed = document.querySelector('#quote-box');

    if (isRandomQuoteDisplayed) {
        getQuote(url, displayQuote);
        const newQuote = document.querySelector('#new-quote');
        newQuote.addEventListener('click', () => {
            getQuote(url, displayQuote)
        })
    }
}
})
