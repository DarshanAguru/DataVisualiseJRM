import './Dashboard.css';
import { useState, useMemo, useEffect} from 'react';
import BarChart from './BarChart';


const baseurl = "http://localhost:9000/api/data";





export default function EYvsP()
{
    const[endYearList, setEndyearList] = useState([]);
    const[endyear, setEndyear] = useState(2018);

    const handlechange = (selEy) =>{
        setEndyear(selEy.target.value);
        // console.log(selcountry.target.value);
    }
 

    useMemo(()=>{fetch(baseurl+'/endyearlist')
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
            setEndyearList(data);
            
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
        fetch(`${baseurl}/endyear/${endyear}`)
        .then((response)=> response.json()
        ).then((json)=>{
                
                let dataset = new Map();
                for(let i = 0 ; i < json.length ; i++)
                {
                    if(json[i].pestle !== "Nan")
                    {
                    if(dataset.has(json[i].pestle))
                    {
                        let cnt = dataset.get(json[i].pestle) + 1;
                        dataset.set(json[i].pestle, cnt);
                    }
                    else{
                        dataset.set(json[i].pestle,1);
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
                            label :"No. of Published articles",
                            data :  values,
                            backgroundColor: '#4bcbeb',
                            borderColor: '#000',
                            borderWidth: 1,
                        }
                    ]
                    };
                
                    setChartData(chartdata);
                
        
        })
        .catch((error)=>{console.log(error)});
    },[endyear]);
    

    



    return (
        <div className="chart1">
              <span className='filter'>End Year : </span> 
              <select style = {{"border": "2px solid #4bcbeb"}} className='select-box' value={endyear}  onChange={handlechange}>{endYearList.map((option) => (<option value={option.value}>{option.label}</option>))}</select>
                <BarChart chartData= {chartdata} title="No. of articles published on Pestles at selected Endyear" desc="No. of articles published on Pestles at selected end-year"/>
        </div>
    );
}