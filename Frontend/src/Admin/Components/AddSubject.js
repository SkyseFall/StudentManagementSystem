import axios from "axios"
import { useEffect, useState } from "react"
import { useHistory } from "react-router"
import { BrowserRouter, Link,Route,Switch } from "react-router-dom"
import InsertSubject from "./SubComponents/InsertSubject"
import SubjectRow from "./SubComponents/SubjectRow"
import '../adminHome.css';

const AddSubject = () =>{
    const [classList,setClassList] = useState([])
    const [c,setC] = useState("1");   // here c means standard or class.
    const [subjectList,setSubjectList] = useState([])

    const history = useHistory()

    const url = "http://localhost:8080"
     useEffect(() =>{
         getClasses()
     },[])

    const getClasses = () =>{
        axios.get(url+"/class/getDistinctClasses").then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                console.log(result.data)
                setClassList(result.data)
            }else if(result.status == "zero"){
                window.alert(result.message)
                history.push('/AdminHome')
            }
        })
            
    }

    const SubjectsRow = () =>{
        const body ={
            "std": c
        }
        axios.post(url+"/class/subjects",body).then(Response =>{
            const result = Response.data
            console.log(result.data)
            if(result.status == "success"){
            //console.log(result.data)
            setSubjectList(result.data)
        }
        })
        //console.log(subjectList)
    }

    return(
        <div className="container">
            Select Class : 
            {/* <button onClick={getClasses}>Get Classes</button> */}

            <select onChange={e=>{setC(e.target.value)}}>
            {                    
                classList.map((l) =>{
                return (
                    <option key={l} value={l}>{l}</option>
                    )
                })
            }
            </select>
                <button className="button-small" onClick={SubjectsRow}>Show</button>
                <br/><br/>
            <table className="table">
                <thead>
                    <tr>
                        <th>Subject Code</th>
                        <th>Subject Name</th>
                        <th>Total Marks</th>
                        <th>Total Assignment Marks</th>
                        <th>Faculty Assigned</th>
                    </tr>
                </thead>
                 <tbody>
                    {
                        subjectList.map((subject) =>{
                            return <SubjectRow key={subject.subjectCode} s={subject} />
                        })
                    }
                </tbody>
            </table>
            <BrowserRouter>
                    
                    <li>
                    <Link to={{
                        pathname:'/InsertSubject',
                        aboutProps:{
                            id : {c}
                        }
                    }

                    }>Add Subject</Link>
                    </li>

                    <Switch>
                        <Route path='/InsertSubject' component={InsertSubject} />
                    </Switch>
            </BrowserRouter>
        </div>
    )
}
export default AddSubject