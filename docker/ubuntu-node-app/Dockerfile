FROM ubuntu-nodejs-2

RUN mkdir /app
ADD app.js /app
ADD package.json /app

WORKDIR /app
RUN npm install

EXPOSE 8080
CMD [ "node", "app.js" ]

