import './Dashboard.css';
import { useState, useMemo, useEffect} from 'react';
import BarChart from './BarChart';


const baseurl = "http://localhost:9000/api/data";





export default function EYvsP()
{
    const[pestleList, setPestleList] = useState([]);
    const[pestle, setPestle] = useState("Technological");

    const handlechange = (selPestle) =>{
        setPestle(selPestle.target.value);
        // console.log(selcountry.target.value);
    }
 

    useMemo(()=>{fetch(baseurl+'/pestlelist')
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
            setPestleList(data);
            
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
        fetch(`${baseurl}/pestle/${pestle}`)
        .then((response)=> response.json()
        ).then((json)=>{
                
                let dataset = new Map();
                for(let i = 0 ; i < json.length ; i++)
                {
                    if(json[i].sector !== "Nan")
                    {
                    if(dataset.has(json[i].sector))
                    {
                        let intensity = dataset.get(json[i].sector) + json[i].intensity;
                        dataset.set(json[i].sector, intensity);
                    }
                    else{
                        dataset.set(json[i].sector,json[i].intensity);
                    }
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
                            label :"Intensity",
                            data :  values,
                            backgroundColor: '#1bcfb4',
                            borderColor: '#000',
                            borderWidth: 1,
                        }
                    ]
                    };
                
                    setChartData(chartdata);
                
        
        })
        .catch((error)=>{console.log(error)});
    },[pestle]);
    

    



    return (
        <div className="chart1">
              <span className='filter'>Pestle : </span> 
              <select style = {{"border": "2px solid #1bcfb4"}} className='select-box' value={pestle}  onChange={handlechange}>{pestleList.map((option) => (<option value={option.value}>{option.label}</option>))}</select>
                <BarChart chartData= {chartdata} title="Intensity vs Sector on selected Pestle" desc="Intensity vs Sector on selected Pestle"/>
        </div>
    );
}