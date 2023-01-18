import CreateCharts from "@/assets/js/CreateCharts";

class SetupChart {
    constructor(sensor_data, sensor_name, sensor_group, chart_type, chart_name) {
        // Sensor data for chart
        this.sensor_data = sensor_data;
        this.sensor_name = sensor_name;
        this.sensor_group = sensor_group;
        this.chart_type = chart_type;
        this.chart_name = chart_name;

        // Default values
        this.canvas = null;
        this.data_points = [];
        this.min_data_points = 0;
        this.max_data_points = 0;
        this.max_data_points = 0;
    }

    createChart() {
        this.createDataPoints();
        this.createCanvas();
        this.setupChart();

        return this.canvas;
    }

    async createDataPoints() {
        this.data_points = JSON.parse(this.sensor_data);
        if (this.sensor_name == null) {
            this.data_points = await this.data_points.filter((sensor) => sensor["group"] === this.sensor_group);
            console.log(this.data_points)
        } else {
            this.data_points = await this.data_points.filter((sensor) => sensor["sensorName"] === this.sensor_name);
        }
    }

    createCanvas() {
        this.canvas = document.createElement("canvas");
        this.canvas.id = this.chart_name;
    }

    setupChart() {
        switch (this.chart_type) {
            case "line":
                this.min_data_points = 4;
                this.max_data_points = 8;
                break;
            case "bar":
                this.min_data_points = 2;
                this.max_data_points = 2;
                break;
            case "pie":
                this.min_data_points = 2;
                this.max_data_points = 8;
                break;
        }

        // Check if there is enough data to display the graph
        if (this.data_points.length < this.min_data_points) {
            this.lackData = true;
            return
        }

        // Only get last max data points values
        this.data_points = this.data_points.slice(this.data_points.length - this.max_data_points, this.data_points.length);

        // Setup chart
        const ctx = this.canvas.getContext('2d');
        const gradient = ctx.createLinearGradient(0, 0, 0, 250);
        gradient.addColorStop(0, '#29acda');
        gradient.addColorStop(1, 'rgba(0, 44, 72, 0)');

        switch (this.chart_type) {
            case "line":
                CreateCharts.createLineChart(ctx, gradient, this.data_points);
                break;
            case "bar":
                CreateCharts.createBarChart(ctx, gradient, this.data_points);
                break;
            case "pie":
                CreateCharts.createPieChart(ctx, gradient, this.data_points);
                break;
        }
    }
}

export default SetupChart;