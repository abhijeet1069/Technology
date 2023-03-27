const express = require('express');

const app = express();

app.use(express.static('tutorial3'));

app.listen(3000);