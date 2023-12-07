import './Dashboard.css';
import { Bar } from 'react-chartjs-2';


export default function BarChart(props){
    return (
        <div className='barchart'>
            <h2>{props.title}</h2>
            <Bar 
                data={props.chartData}
                options = {{
                    plugin: {
                        title: {
                            display: true,
                            text: props.desc
                        },
                        legend:{
                            display : false
                        }
                    }
                }}
            />
        </div>
    );
}