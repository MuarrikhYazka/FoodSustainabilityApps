$(function () {
  /* ChartJS
   * -------
   * Data and config for chartjs
   */
  'use strict';
  var data = {
    labels: ["2013", "2014", "2015", "2016", "2017", "2018", "2019"],
    datasets: [{
      label: 'Inflasi % ',
      data: [3.30, 3.30, 3.30, 2.37, 3.72, 3.27, 3.27],
      backgroundColor: [
        'rgba(255, 99, 132, 0.2)',
        'rgba(54, 162, 235, 0.2)',
        'rgba(255, 206, 86, 0.2)',
        'rgba(75, 192, 192, 0.2)',
        'rgba(153, 102, 255, 0.2)',
        'rgba(255, 159, 64, 0.2)'
      ],
      borderColor: [
        '#9a55ff'//,
        // 'rgba(54, 162, 235, 1)',
        // 'rgba(255, 206, 86, 1)',
        // 'rgba(75, 192, 192, 1)',
        // 'rgba(153, 102, 255, 1)',
        // 'rgba(255, 159, 64, 1)'
      ],
      borderWidth: 3,
      fill: false
    }]
  };

  var data2 = {
    labels: ["2013", "2014", "2015", "2016", "2017", "2018", "2019"],
    datasets: [{
      label: 'Inflasi IHK ',
      data: [50, 20, 10, 30, 18, 25, 37, 15],
      backgroundColor: [
        'rgba(255, 99, 132, 0.2)',
        'rgba(54, 162, 235, 0.2)',
        'rgba(255, 206, 86, 0.2)',
        'rgba(75, 192, 192, 0.2)',
        'rgba(153, 102, 255, 0.2)',
        'rgba(255, 159, 64, 0.2)'
      ],
      borderColor: [
        '#9a55ff'//,
        // 'rgba(54, 162, 235, 1)',
        // 'rgba(255, 206, 86, 1)',
        // 'rgba(75, 192, 192, 1)',
        // 'rgba(153, 102, 255, 1)',
        // 'rgba(255, 159, 64, 1)'
      ],
      borderWidth: 3,
      fill: false
    }]
  };

  var dataDark = {
    labels: ["2013", "2014", "2015", "2016", "2017", "2018", "2019"],
    datasets: [{
      label: '# of Votes',
      data: [0.50, 0.80, 1.20, 0.30, 0.18, 0.25, 0.17, 0.25],
      backgroundColor: [
        'rgba(255, 99, 132, 0.2)',
        'rgba(54, 162, 235, 0.2)',
        'rgba(255, 206, 86, 0.2)',
        'rgba(75, 192, 192, 0.2)',
        'rgba(153, 102, 255, 0.2)',
        'rgba(255, 159, 64, 0.2)'
      ],
      borderColor: [
        'rgba(255,99,132,1)',
        'rgba(54, 162, 235, 1)',
        'rgba(255, 206, 86, 1)',
        'rgba(75, 192, 192, 1)',
        'rgba(153, 102, 255, 1)',
        'rgba(255, 159, 64, 1)'
      ],
      borderWidth: 1,
      fill: false
    }]
  };
  var multiLineData = {
    labels: ["2013", "2014", "2015", "2016", "2017", "2018", "2019"],
    borderDash: [5, 5],
    datasets: [{
      label: 'APBD',
      data: [10, 19, 23, 25, 32, 65, 75, 85],
      borderColor: [
        '#587ce4'
      ],
      borderWidth: 2,
      fill: false
    },
    {
      label: 'Batas Wajar Atas',
      data: [15, 27, 38, 30, 37, 38, 45, 60],
      borderColor: [
        '#f44252'
      ],
      borderWidth: 2,
      borderDash: [5, 5],
      fill: false
    },
    {
      label: 'Batas Wajar Bawah',
      data: [5, 11, 20, 20, 27, 28, 35, 50],
      borderColor: [
        '#f44252'
      ],
      borderWidth: 2,
      borderDash: [5, 5],
      fill: false
    }
    ]
  };
  var options = {
    scales: {
      yAxes: [{
        ticks: {
          beginAtZero: true
        }
      }]
    },
    legend: {
      display: false
    },
    elements: {
      point: {
        radius: 1
      }
    }

  };
  var optionsDark = {
    scales: {
      yAxes: [{
        ticks: {
          beginAtZero: true
        },
        gridLines: {
          color: '#322f2f',
          zeroLineColor: '#322f2f'
        }
      }],
      xAxes: [{
        ticks: {
          beginAtZero: true
        },
        gridLines: {
          color: '#322f2f',
        }
      }],
    },
    legend: {
      display: false
    },
    elements: {
      point: {
        radius: 1
      }
    }

  };
  var doughnutPieData = {
    datasets: [{
      data: [30, 40, 30],
      backgroundColor: [
        'rgba(255, 99, 132, 0.5)',
        'rgba(54, 162, 235, 0.5)',
        'rgba(255, 206, 86, 0.5)',
        'rgba(75, 192, 192, 0.5)',
        'rgba(153, 102, 255, 0.5)',
        'rgba(255, 159, 64, 0.5)'
      ],
      borderColor: [
        'rgba(255,99,132,1)',
        'rgba(54, 162, 235, 1)',
        'rgba(255, 206, 86, 1)',
        'rgba(75, 192, 192, 1)',
        'rgba(153, 102, 255, 1)',
        'rgba(255, 159, 64, 1)'
      ],
    }],

    // These labels appear in the legend and in the tooltips when hovering different arcs
    labels: [
      'Pink',
      'Blue',
      'Yellow',
    ]
  };
  var doughnutPieOptions = {
    responsive: true,
    animation: {
      animateScale: true,
      animateRotate: true
    }
  };
  var areaData = {
    labels: ["2013", "2014", "2015", "2016", "2017"],
    datasets: [{
      label: '# of Votes',
      data: [12, 19, 3, 5, 2, 3],
      backgroundColor: [
        'rgba(255, 99, 132, 0.2)',
        'rgba(54, 162, 235, 0.2)',
        'rgba(255, 206, 86, 0.2)',
        'rgba(75, 192, 192, 0.2)',
        'rgba(153, 102, 255, 0.2)',
        'rgba(255, 159, 64, 0.2)'
      ],
      borderColor: [
        'rgba(255,99,132,1)',
        'rgba(54, 162, 235, 1)',
        'rgba(255, 206, 86, 1)',
        'rgba(75, 192, 192, 1)',
        'rgba(153, 102, 255, 1)',
        'rgba(255, 159, 64, 1)'
      ],
      borderWidth: 1,
      fill: true, // 3: no fill
    }]
  };

  var areaDataDark = {
    labels: ["2013", "2014", "2015", "2016", "2017"],
    datasets: [{
      label: '# of Votes',
      data: [12, 19, 3, 5, 2, 3],
      backgroundColor: [
        'rgba(255, 99, 132, 0.2)',
        'rgba(54, 162, 235, 0.2)',
        'rgba(255, 206, 86, 0.2)',
        'rgba(75, 192, 192, 0.2)',
        'rgba(153, 102, 255, 0.2)',
        'rgba(255, 159, 64, 0.2)'
      ],
      borderColor: [
        'rgba(255,99,132,1)',
        'rgba(54, 162, 235, 1)',
        'rgba(255, 206, 86, 1)',
        'rgba(75, 192, 192, 1)',
        'rgba(153, 102, 255, 1)',
        'rgba(255, 159, 64, 1)'
      ],
      borderWidth: 1,
      fill: true, // 3: no fill
    }]
  };

  var areaOptions = {
    plugins: {
      filler: {
        propagate: true
      }
    }
  }

  var areaOptionsDark = {
    scales: {
      yAxes: [{
        ticks: {
          beginAtZero: true
        },
        gridLines: {
          color: '#322f2f',
          zeroLineColor: '#322f2f'
        }
      }],
      xAxes: [{
        ticks: {
          beginAtZero: true
        },
        gridLines: {
          color: '#322f2f',
        }
      }],
    },
    plugins: {
      filler: {
        propagate: true
      }
    }
  }

  var multiAreaData = {
    labels: ["2013", "2014", "2015", "2016", "2017", "2018", "2019"],    
    datasets: [{
      label: 'APBD',
      data: [10, 19, 23, 25, 32, 33, 40, 55],
      borderColor: ['rgba(54, 162, 235, 0.5)'],
      backgroundColor: ['rgba(255, 99, 132, 0.5)'],
      borderWidth: 1,
      fill: true
    },
    {
      label: 'Batas Atas',
      data: [15, 24, 28, 30, 37, 38, 45, 60],      
      borderColor: ['rgba(255, 99, 132, 0.5)'],      
      backgroundColor: ['rgba(255, 99, 132, 0.5)'],
      borderWidth: 1,
      fill: true
    },
    {
      label: 'Batas Bawah',
      data: [5, 14, 18, 20, 27, 28, 35, 50],      
      borderColor: ['rgba(255, 206, 86, 0.5)'],
      borderWidth: 1,
      fill: true
    }
    ]
  };

  var multiAreaOptions = {
    plugins: {
      filler: {
        propagate: true
      }
    },
    elements: {
      point: {
        radius: 1
      }
    },
    scales: {
      xAxes: [{
        gridLines: {
          display: false
        }
      }],
      yAxes: [{
        gridLines: {
          display: false
        }
      }]
    }
  }

  var scatterChartData = {
    datasets: [{
      label: 'First Dataset',
      data: [{
        x: -10,
        y: 0
      },
      {
        x: 0,
        y: 3
      },
      {
        x: -25,
        y: 5
      },
      {
        x: 40,
        y: 5
      }
      ],
      backgroundColor: [
        'rgba(255, 99, 132, 0.2)'
      ],
      borderColor: [
        'rgba(255,99,132,1)'
      ],
      borderWidth: 1
    },
    {
      label: 'Second Dataset',
      data: [{
        x: 10,
        y: 5
      },
      {
        x: 20,
        y: -30
      },
      {
        x: -25,
        y: 15
      },
      {
        x: -10,
        y: 5
      }
      ],
      backgroundColor: [
        'rgba(54, 162, 235, 0.2)',
      ],
      borderColor: [
        'rgba(54, 162, 235, 1)',
      ],
      borderWidth: 1
    }
    ]
  }

  var scatterChartDataDark = {
    datasets: [{
      label: 'First Dataset',
      data: [{
        x: -10,
        y: 0
      },
      {
        x: 0,
        y: 3
      },
      {
        x: -25,
        y: 5
      },
      {
        x: 40,
        y: 5
      }
      ],
      backgroundColor: [
        'rgba(255, 99, 132, 0.2)'
      ],
      borderColor: [
        'rgba(255,99,132,1)'
      ],
      borderWidth: 1
    },
    {
      label: 'Second Dataset',
      data: [{
        x: 10,
        y: 5
      },
      {
        x: 20,
        y: -30
      },
      {
        x: -25,
        y: 15
      },
      {
        x: -10,
        y: 5
      }
      ],
      backgroundColor: [
        'rgba(54, 162, 235, 0.2)',
      ],
      borderColor: [
        'rgba(54, 162, 235, 1)',
      ],
      borderWidth: 1
    }
    ]
  }

  var scatterChartOptions = {
    scales: {
      xAxes: [{
        type: 'linear',
        position: 'bottom'
      }]
    }
  }

  var scatterChartOptionsDark = {
    scales: {
      xAxes: [{
        type: 'linear',
        position: 'bottom',
        gridLines: {
          color: '#322f2f',
          zeroLineColor: '#322f2f'
        }
      }],
      yAxes: [{
        gridLines: {
          color: '#322f2f',
          zeroLineColor: '#322f2f'
        }
      }]
    }
  }

  // var config = {
  //   type: 'line',
  //   data: {
  //     labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
  //     datasets: [{
  //       label: 'Unfilled',
  //       fill: false,
  //       backgroundColor: window.chartColors.blue,
  //       borderColor: window.chartColors.blue,
  //       data: [
  //         randomScalingFactor(),
  //         randomScalingFactor(),
  //         randomScalingFactor(),
  //         randomScalingFactor(),
  //         randomScalingFactor(),
  //         randomScalingFactor(),
  //         randomScalingFactor()
  //       ],
  //     }, {
  //       label: 'Dashed',
  //       fill: false,
  //       backgroundColor: window.chartColors.green,
  //       borderColor: window.chartColors.green,
  //       borderDash: [5, 5],
  //       data: [
  //         randomScalingFactor(),
  //         randomScalingFactor(),
  //         randomScalingFactor(),
  //         randomScalingFactor(),
  //         randomScalingFactor(),
  //         randomScalingFactor(),
  //         randomScalingFactor()
  //       ],
  //     }, {
  //       label: 'Filled',
  //       backgroundColor: window.chartColors.red,
  //       borderColor: window.chartColors.red,
  //       data: [
  //         randomScalingFactor(),
  //         randomScalingFactor(),
  //         randomScalingFactor(),
  //         randomScalingFactor(),
  //         randomScalingFactor(),
  //         randomScalingFactor(),
  //         randomScalingFactor()
  //       ],
  //       fill: true,
  //     }]
  //   },
  //   options: {
  //     responsive: true,
  //     title: {
  //       display: true,
  //       text: 'Chart.js Line Chart'
  //     },
  //     tooltips: {
  //       mode: 'index',
  //       intersect: false,
  //     },
  //     hover: {
  //       mode: 'nearest',
  //       intersect: true
  //     },
  //     scales: {
  //       xAxes: [{
  //         display: true,
  //         scaleLabel: {
  //           display: true,
  //           labelString: 'Month'
  //         }
  //       }],
  //       yAxes: [{
  //         display: true,
  //         scaleLabel: {
  //           display: true,
  //           labelString: 'Value'
  //         }
  //       }]
  //     }
  //   }
  // };

  // window.onload = function() {
  //   var ctx = document.getElementById('canvas').getContext('2d');
  //   window.myLine = new Chart(ctx, config);
  // };


  // Get context with jQuery - using jQuery's .get() method.
  if ($("#barChart").length) {
    var barChartCanvas = $("#barChart").get(0).getContext("2d");
    // This will get the first returned node in the jQuery collection.
    var barChart = new Chart(barChartCanvas, {
      type: 'bar',
      data: data2,
      options: options
    });
  }

  if ($("#barChartDark").length) {
    var barChartCanvasDark = $("#barChartDark").get(0).getContext("2d");
    // This will get the first returned node in the jQuery collection.
    var barChartDark = new Chart(barChartCanvasDark, {
      type: 'bar',
      data: dataDark,
      options: optionsDark
    });
  }

  if ($("#lineChart").length) {
    var lineChartCanvas = $("#lineChart").get(0).getContext("2d");
    var lineChart = new Chart(lineChartCanvas, {
      type: 'line',
      data: data,
      options: options
    });
  }

  if ($("#lineChart2").length) {
    var lineChartCanvas = $("#lineChart2").get(0).getContext("2d");
    var lineChart = new Chart(lineChartCanvas, {
      type: 'line',
      data: data2,
      options: options
    });
  }

  if ($("#lineChartDark").length) {
    var lineChartCanvasDark = $("#lineChartDark").get(0).getContext("2d");
    var lineChartDark = new Chart(lineChartCanvasDark, {
      type: 'line',
      data: dataDark,
      options: optionsDark
    });
  }

  // if ($("#linechart-multi").length) {
  //   var multiLineCanvas = $("#linechart-multi").get(0).getContext("2d");
  //   var lineChart = new Chart(multiLineCanvas, {
  //     type: 'line',
  //     data: multiLineData,
  //     options: options
  //   });
  // }

  if ($("#areachart-multi").length) {
    var multiAreaCanvas = $("#areachart-multi").get(0).getContext("2d");
    var multiAreaChart = new Chart(multiAreaCanvas, {
      type: 'line',
      data: multiAreaData,
      options: multiAreaOptions
    });
  }

  if ($("#doughnutChart").length) {
    var doughnutChartCanvas = $("#doughnutChart").get(0).getContext("2d");
    var doughnutChart = new Chart(doughnutChartCanvas, {
      type: 'doughnut',
      data: doughnutPieData,
      options: doughnutPieOptions
    });
  }

  if ($("#pieChart").length) {
    var pieChartCanvas = $("#pieChart").get(0).getContext("2d");
    var pieChart = new Chart(pieChartCanvas, {
      type: 'pie',
      data: doughnutPieData,
      options: doughnutPieOptions
    });
  }

  if ($("#areaChart").length) {
    var areaChartCanvas = $("#areaChart").get(0).getContext("2d");
    var areaChart = new Chart(areaChartCanvas, {
      type: 'line',
      data: areaData,
      options: areaOptions
    });
  }

  if ($("#areaChartDark").length) {
    var areaChartCanvas = $("#areaChartDark").get(0).getContext("2d");
    var areaChart = new Chart(areaChartCanvas, {
      type: 'line',
      data: areaDataDark,
      options: areaOptionsDark
    });
  }

  if ($("#scatterChart").length) {
    var scatterChartCanvas = $("#scatterChart").get(0).getContext("2d");
    var scatterChart = new Chart(scatterChartCanvas, {
      type: 'scatter',
      data: scatterChartData,
      options: scatterChartOptions
    });
  }

  if ($("#scatterChartDark").length) {
    var scatterChartCanvas = $("#scatterChartDark").get(0).getContext("2d");
    var scatterChart = new Chart(scatterChartCanvas, {
      type: 'scatter',
      data: scatterChartDataDark,
      options: scatterChartOptionsDark
    });
  }

  if ($("#browserTrafficChart").length) {
    var doughnutChartCanvas = $("#browserTrafficChart").get(0).getContext("2d");
    var doughnutChart = new Chart(doughnutChartCanvas, {
      type: 'doughnut',
      data: browserTrafficData,
      options: doughnutPieOptions
    });
  }

  if ($("#harga-barang-chart").length) {
    Chart.defaults.global.legend.labels.usePointStyle = true;
    var ctx = document.getElementById('harga-barang-chart').getContext("2d");

    var gradientStrokeViolet = ctx.createLinearGradient(0, 0, 0, 181);
    gradientStrokeViolet.addColorStop(0, 'rgba(218, 140, 255, 1)');
    gradientStrokeViolet.addColorStop(1, 'rgba(154, 85, 255, 1)');
    var gradientLegendViolet = 'linear-gradient(to right, rgba(218, 140, 255, 1), rgba(154, 85, 255, 1))';
    
    var gradientStrokeBlue = ctx.createLinearGradient(0, 0, 0, 360);
    gradientStrokeBlue.addColorStop(0, 'rgba(54, 215, 232, 1)');
    gradientStrokeBlue.addColorStop(1, 'rgba(177, 148, 250, 1)');
    var gradientLegendBlue = 'linear-gradient(to right, rgba(54, 215, 232, 1), rgba(177, 148, 250, 1))';

    var gradientStrokeRed = ctx.createLinearGradient(0, 0, 0, 300);
    gradientStrokeRed.addColorStop(0, 'rgba(255, 191, 150, 1)');
    gradientStrokeRed.addColorStop(1, 'rgba(254, 112, 150, 1)');
    var gradientLegendRed = 'linear-gradient(to right, rgba(255, 191, 150, 1), rgba(254, 112, 150, 1))';

    var myChart = new Chart(ctx, {
      type: 'bar',
      data: {
          labels: ['Air Mineral', 'Spanduk', 'Kertas F4', 'Tinta Printer', 'Ballpoint', 'Binderclip', 'Oli Mesin', 'Lampu TLD'],
          datasets: [
            
            {
              label: "Harga dalam APBD",
              borderColor: gradientStrokeRed,
              backgroundColor: gradientStrokeRed,
              hoverBackgroundColor: gradientStrokeRed,
              legendColor: gradientLegendRed,
              pointRadius: 0,
              fill: false,
              borderWidth: 1,
              fill: 'origin',
              data: [40000, 100000, 65000, 185000, 50000, 6500, 120000, 100000]
              
            },
            {
              label: "Rata-rata Harga Pasar",
              borderColor: gradientStrokeBlue,
              backgroundColor: gradientStrokeBlue,
              hoverBackgroundColor: gradientStrokeBlue,
              legendColor: gradientLegendBlue,
              pointRadius: 0,
              fill: false,
              borderWidth: 1,
              fill: 'origin',
              data: [38542.075, 109095.8333, 69684.525, 186325.7833, 57442.10833, 8930.2, 135268.7917, 137994.0833]
            }
        ]
      },
      options: {
        responsive: true,
        legend: false,
        legendCallback: function(chart) {
          var text = []; 
          text.push('<ul>'); 
          for (var i = 0; i < chart.data.datasets.length; i++) { 
              text.push('<li><span class="legend-dots" style="background:' + 
                         chart.data.datasets[i].legendColor + 
                         '"></span>'); 
              if (chart.data.datasets[i].label) { 
                  text.push(chart.data.datasets[i].label); 
              } 
              text.push('</li>'); 
          } 
          text.push('</ul>'); 
          return text.join('');
        },
        scales: {
            yAxes: [{
                ticks: {
                    display: false,
                    min: 0
                    
                    
                },
                gridLines: {
                  drawBorder: false,
                  color: 'rgba(235,237,242,1)',
                  zeroLineColor: 'rgba(235,237,242,1)'
                }
            }],
            xAxes: [{
                gridLines: {
                  display:false,
                  drawBorder: false,
                  color: 'rgba(0,0,0,1)',
                  zeroLineColor: 'rgba(235,237,242,1)'
                },
                ticks: {
                    padding: 20,
                    fontColor: "#9c9fa6",
                    autoSkip: true,
                },
                categoryPercentage: 0.5,
                barPercentage: 0.5
            }]
          }
        },
        elements: {
          point: {
            radius: 0
          }
        }
    })
    $("#harga-barang-chart-legend").html(myChart.generateLegend());
  }

  if ($("#harga-barang-dot").length) {
    var scatterChartCanvas = $("#scatterChart").get(0).getContext("2d");
    var scatterChart = new Chart(scatterChartCanvas, {
      type: 'scatter',
      data: scatterChartData,
      options: scatterChartOptions
    });

  }

});