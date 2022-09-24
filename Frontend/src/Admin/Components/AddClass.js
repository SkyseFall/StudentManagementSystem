import axios from "axios"
import { useEffect, useState } from "react"
import { useHistory } from "react-router"
import '../adminHome.css'
const AddClass = () =>{
    const[std,setStd] = useState("")
    const[classRep,setClassRep] = useState("")
    const[teacherRep,setTeacherRep] = useState("")
    const[teachers,setTeachers] = useState([])
    const[students,setStudents] = useState([])

    const history = useHistory()

    const url = "http://localhost:8080"

    useEffect(() =>{
        preReqAddClass()
    },[])

    const submitClass = () =>{
        const body ={
            "std": std,
            "classRep": classRep,
            "teacherRep": teacherRep
        }
        axios.post(url+"/class/addClass",body).then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                window.alert("Class Added Succesfully..")
                history.push('/AdminHome')
            }else{
                window.alert(result.message)
            }
        })
    }

    const preReqAddClass = () =>{
        
        axios.get(url+"/users/getTeachersStudents").then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                //console.log(result.teachers)
                setTeachers(result.teachers)
                //console.log(result.students)
                setStudents(result.students)
            }
        })
    }

    const Back = () =>{
        history.push('/AdminHome')
    }

    return(
        <div className="container "> 
        <div className="add">
            <table >
                <tr>
                    <td>Standard : </td>
                    <td>
                        <input onChange={e=>{setStd(e.target.value)}} type="text" required />
                    </td>
                </tr>
                <tr>
                    <td>Student Representative : </td>
                    <td>
                        <select onChange={e=>{setClassRep(e.target.value)}}>
                            <option value="0">None</option>
                                {
                                    //console.log(students)
                                    
                                    students.map((s) =>{
                                        return (
                                            <option key={s} value={s}>{s}</option>
                                        )
                                    })
                                }
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Teacher Representative : </td>
                    <td>
                        <select onChange={e=>{setTeacherRep(e.target.value)}}>
                            <option value="0">None</option>
                                {
                                    //console.log(students)
                                    
                                    teachers.map((t) =>{
                                        return (
                                            <option key={t} value={t}>{t}</option>
                                        )
                                    })
                                }
                        </select>
                    </td>
                </tr>
            </table>
            <div  className="b-spacing"><button className="button" onClick={Back}>Back</button></div>
            <div ><button className="button" onClick={submitClass}>Add</button></div>
            </div>
            
            

            

        </div>
    )
}

export default AddClass