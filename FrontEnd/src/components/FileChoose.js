import React, {useEffect, useState} from 'react';
import Papa from 'papaparse';
import './FileChoose.css';

function FileChooser(){
    const [file, setFile] = useState(null);
    const [rawJson, setRawJson] = useState(null);
    const [data, setData] = useState(null);

    useEffect(()=>{
        if(rawJson)
        {
            const Siunciam = 
            <div className="CSVPagrindinis">
                <div className="CSVVisas">
                    <div className="Stulpelis">Name</div>
                    <div className="Stulpelis">Gmail</div>
                    <div className="Stulpelis">Phone Number</div>
                </div>
            {rawJson.map((result, index) => (
                <div id={result.id} key={index} className="Eilute">
                    <div className="Stulpelis">{result.Name}</div>
                    <div className="Stulpelis">{result.Email}</div>
                    <div className="Stulpelis">{result["Phone Number"]}</div>
                </div>
                ))}
            </div>
            setData(Siunciam);
        }
        
    },[rawJson]);
    
    const handleFileChange = (e) => {
        setFile(e.target.files[0]);
    }
    
    const handleFileUpload = () => {
        if (!file) {
            alert('No file selected');
        } else {
            Papa.parse(file, {
                header: true,
                complete: handleData
            });
        }
    }
    async function Update() {
        const response = await fetch('http://localhost:8080/api/v1/person');
        const data = await response.json();
        setRawJson(data);
    }

    async function FetchPost(results){
        await fetch('http://localhost:8080/api/v1/person', {  // Enter your IP address here

        method: 'POST', 
        mode: 'cors', 
        body: JSON.stringify(results.data), // body data type must match "Content-Type" header
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
          },
  
      })
    }
    
    const handleData = async (results) => {
        await FetchPost(results);
        await Update();
    }
    

    
    return (
      <div className="FullScreen">
        <div className="InputDiv">
            <input className="Input1" type="file" onChange={handleFileChange} />
        </div>
        <button className="ButtonUpload" onClick={handleFileUpload}>Upload</button>
        <div className="Lentele">{data}</div>
      </div>
    );
}
export default FileChooser;
