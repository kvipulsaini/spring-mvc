var chartData = decodeHtml(chartData);
console.log("data:"+chartData);
var chartJsonArray = JSON.parse(chartData);

var arrayLength = chartJsonArray.length;
var numericData = [];
var labelData = [];

for(var i=0; i<arrayLength; i++){
numericData[i] = chartJsonArray[i].value;
labelData[i] = chartJsonArray[i].label;
}
new Chart(document.getElementById("myPieChart"), {
type : 'pie',
    data: {
      labels: labelData,
      datasets: [{
        label: '# of Votes',
        background: 'rgb(255, 99, 132)',
        data: numericData
      }]
    },
    options: {
        title:{
            display: true,
            text: 'Project Status'
        }

    }

});

function decodeHtml(html){
var txt = document.createElement("textarea");
txt.innerHTML = html;
return txt.value;
}