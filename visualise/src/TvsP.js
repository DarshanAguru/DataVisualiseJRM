import './Dashboard.css';
import { useState, useMemo, useEffect} from 'react';
import BarChart from './BarChart';


const baseurl = "http://localhost:9000/api/data";





export default function TvsP()
{
    const[topicList, setTopicList] = useState([]);
    const[topic, setTopic] = useState("artificial intelligence");

    const handlechange = (selTopic) =>{
        setTopic(selTopic.target.value);
        // console.log(selcountry.target.value);
    }
 

    useMemo(()=>{fetch(baseurl+'/topiclist')
    .then(
        (response)=> response.json()
    )
    .then(
        (json) => {

            var data = []
          
            for(let i = 0; i < json.length; i++)
            {
                data.push({id: i,value:json[i], label:json[i]});
                   
            } 
            setTopicList(data);
            
            // console.log(countryList);
        }
    )
    .catch(
        (error)=>{console.log("err")}
    );},[]);
 

    const[chartdata , setChartData] = useState({
        label : ['a','b','c','d'],
        datasets: [
            {
                title :"Barchart",
                data :  [1,2,3,4],
                backgroundColor : ['#ff0000'],
                borderWidth: 1,
            }
        ]
        });
    
    useEffect(()=>{
        fetch(`${baseurl}/topic/${topic}`)
        .then((response)=> response.json()
        ).then((json)=>{
                
                let dataset = new Map();
                for(let i = 0 ; i < json.length ; i++)
                {
                    
                    if(dataset.has(json[i].endYear))
                    {
                        let cnt = dataset.get(json[i].endYear) + 1;
                        dataset.set(json[i].endYear, cnt);
                    }
                    else{
                        dataset.set(json[i].endYear,1);
                    }
                    
                }

                let labels = [];
                let values = [];
                
                dataset.forEach((k,v)=>{
                    labels.push(v);
                    values.push(k);
                });
                console.log(labels);
                var chartdata = {
                    labels : labels,
                    datasets: [
                        {
                            label :"No. of Published articles",
                            data :  values,
                            backgroundColor: '#a05aff',
                            borderColor: '#000',
                            borderWidth: 1,
                        }
                    ]
                    };
                
                    setChartData(chartdata);
                
        
        })
        .catch((error)=>{console.log(error)});
    },[topic]);
    

    



    return (
        <div className="chart1">
              <span className='filter'>Topic : </span> 
              <select style = {{"border": "2px solid #a05aff"}} className='select-box' value={topic}  onChange={handlechange}>{topicList.map((option) => (<option value={option.value}>{option.label}</option>))}</select>
                <BarChart chartData= {chartdata} title="No. of articles published on selected Topic (Endyear-wise)" desc="No. of articles published on selected Topic (year-wise)"/>
        </div>
    );
}