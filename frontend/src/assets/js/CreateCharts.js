import Chart from "chart.js/auto";

class CreateCharts {
    createBarChart(ctx, gradient, data_points) {
        const labels = data_points.map((battery) => battery["sensorName"])
        const data = data_points.map((battery) => parseInt(battery["value"]))

        return new Chart(ctx, {
            type: 'bar',
            data: {
                labels: labels,
                datasets: [{
                    label: 'Percentage',
                    data: data,
                    backgroundColor: gradient,
                    fill: true,
                    barThickness: 40,
                    borderWidth: 1,
                }]
            },

            options: {
                maintainAspectRatio: false,
                responsive: true,
                scales: {
                    x: {
                        ticks: {
                            font: {
                                size: 17,
                                weight: "bold"
                            }
                        },
                        grid: {
                            display: false
                        }
                    },
                    y: {
                        ticks: {
                            font: {
                                size: 13,
                            }
                        },
                        grid: {
                            display: false
                        }
                    }
                },
                plugins: {
                    legend: {
                        display: false,
                        font: {
                            size: 30
                        }
                    }
                }
            }
        });
    }

    createLineChart(ctx, gradient, data_points) {
        const labels = data_points.map((usage) => usage["time"].substring(0, 5));
        const data = data_points.map((usage) => usage["value"]);

        return new Chart(ctx, {
            type: 'line',
            data: {
                labels: labels,
                datasets: [{
                    data: data,
                    backgroundColor: gradient,
                    fill: true,
                    barThickness: 40,
                    borderColor: '#29acda',
                    borderWidth: 2,
                }]
            },
            options: {
                maintainAspectRatio: false,
                responsive: true,
                scales: {
                    x: {
                        ticks: {
                            font: {
                                size: 17,
                                weight: "bold"
                            }
                        },
                        grid: {
                            display: false
                        }
                    },
                    y: {
                        ticks: {
                            font: {
                                size: 13,
                            }
                        },
                        grid: {
                            display: false
                        }
                    }
                },
                plugins: {
                    legend: {
                        display: false,
                        font: {
                            size: 30
                        }
                    }
                }
            }
        });
    }

    createPieChart(ctx, gradient, data_points) {
        const labels = data_points.map((usage) => usage["time"].substring(0, 5))
        const data = data_points.map((usage) => usage["value"])

        return new Chart(ctx, {
            type: 'doughnut',
            data: {
                labels: labels,
                datasets: [{
                    data: data,
                    backgroundColor: gradient,
                    fill: true,
                    barThickness: 40,
                    borderColor: '#29acda',
                    borderWidth: 2,
                }]
            },
            options: {
                maintainAspectRatio: false,
                responsive: true,
                scales: {
                    x: {
                        ticks: {
                            font: {
                                size: 17,
                                weight: "bold"
                            }
                        },
                        grid: {
                            display: false
                        }
                    },
                    y: {
                        ticks: {
                            font: {
                                size: 13,
                            }
                        },
                        grid: {
                            display: false
                        }
                    }
                },
                plugins: {
                    legend: {
                        display: false,
                        font: {
                            size: 30
                        }
                    }
                }
            }
        });
    }
}

export default new CreateCharts();