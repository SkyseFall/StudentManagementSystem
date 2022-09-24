import { Route, Switch, useHistory, useLocation } from "react-router";
import { BrowserRouter, Link, NavLink } from "react-router-dom";
import ViewMarksheet from "../Admin/Components/ViewMarksheet";
import ViewMarksOfStudents from "../Admin/Components/ViewMarksOfStudents";
import ViewRanks from "../Admin/Components/ViewRanks";
import MyProfile from "../Pages/Profiles/MyProfile";
import TeacherProfile from "../Pages/Profiles/TeacherProfile";
import AddAssignment from "./Components/AddAssignment";
import CheckBalance from "./Components/CheckBalance";
import GiveStudentsMarks from "./Components/GiveStudentsMarks";
import ReadFeedback from "./Components/ReadFeedback";
import BalanceAmount from "./Components/SubComponents/BalanceAmount";
import TakeStudentAttendance from "./Components/TakeStudentAttendance";
import ViewSchedule from "./Components/ViewSchedule";
import ViewTeacherAttendance from "./Components/ViewTeacherAttendance";
import '../Admin/adminHome.css'
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '../../node_modules/bootstrap/dist/js/bootstrap.bundle'
import Home from "../home/Home";
const TeacherHome = () => {
    const location = useLocation()
    const user = location.state
    const histroy = useHistory();
    const Logout = () => {
        histroy.push('/home')
    }
    return (
        <div>
            <BrowserRouter>

                <nav className="navbar navbar-expand-lg navbar-light bg-dark">
                    <div className="container-fluid">

                        <div className="collapse navbar-collapse" id="navbarNav">
                            <ul className="navbar-nav">

                                <li>
                                    <NavLink className="nav-link adminHome" to={{
                                        pathname: '/profile',
                                        aboutProps: {
                                            id: { user }
                                        }
                                    }

                                    }>My Profile</NavLink>
                                </li>
                                <li>
                                    <NavLink className="nav-link adminHome" to={{
                                        pathname: '/addAssignment',
                                        aboutProps: {
                                            id: { user }
                                        }
                                    }

                                    }>Add Assignment</NavLink>
                                </li>
                                <li className="nav-item dropdown">
                                    <NavLink to="#" className="nav-link dropdown-toggle adminHome" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">View</NavLink>
                                    <ul className="dropdown-menu" >

                                        <li>
                                            <NavLink className="nav-link " to={{
                                                pathname: '/viewScheduleOfTeacher',
                                                aboutProps: {
                                                    id: { user }
                                                }
                                            }

                                            }>Schedule</NavLink>
                                        </li>
                                        <li>
                                            <NavLink className="nav-link " to="/ViewMarksOfStudents"> Marks</NavLink>
                                        </li>
                                        <li>
                                            <NavLink className="nav-link " to="/ViewMarksheet"> Marksheet</NavLink>
                                        </li>
                                        <li>
                                            <NavLink className="nav-link" to="/ViewRanks"> Ranks</NavLink>
                                        </li>

                                    </ul>
                                </li>


                                <li>
                                    <NavLink className="nav-link adminHome" to={{
                                        pathname: '/giveStudentsMarks',
                                        aboutProps: {
                                            id: { user }
                                        }
                                    }
                                    }>Give Marks</NavLink>
                                </li>
                                {/* <li>
                                    <NavLink className="nav-link adminHome" to={{
                                        pathname: '/readFeedback',
                                        aboutProps: {
                                            id: { user }
                                        }
                                    }
                                    }>Feedbacks</NavLink>
                                </li> */}
                                <li>
                                    <NavLink className="nav-link adminHome" to={{
                                        pathname: '/checkBalance',
                                        aboutProps: {
                                            id: { user }
                                        }
                                    }
                                    }>Check Balance</NavLink>
                                </li>


                                <li className="nav-item dropdown">
                                    <NavLink to="#" className="nav-link dropdown-toggle adminHome" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Attendance</NavLink>
                                    <ul className="dropdown-menu" >
                                        <li>
                                            <NavLink className="nav-link " to="/takeStudentsAttendance">Std.Attendance</NavLink>
                                        </li>
                                        <li>
                                            <NavLink className="nav-link " to={{
                                                pathname: '/ViewAttendance',
                                                aboutProps: {
                                                    id: { user }
                                                }
                                            }
                                            }>View Attendance</NavLink>
                                        </li>


                                    </ul>
                                </li>
                                <li className=" navbutton">
                                    <a className="adminHome" href="/home">Logout</a>
                                </li>

                                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;

                                <li className=" navbutton">
                                    <a className="adminHome">Teacher</a>
                                </li>


                            </ul>

                        </div>
                    </div>
                </nav>
                <Switch>
                    <Route path='/profile' component={MyProfile} />
                    <Route path='/teacherProfile' component={TeacherProfile} />
                    <Route path='/addAssignment' component={AddAssignment} />
                    <Route path="/viewScheduleOfTeacher" component={ViewSchedule} />
                    <Route path="/takeStudentsAttendance" component={TakeStudentAttendance} />
                    <Route path="/giveStudentsMarks" component={GiveStudentsMarks} />
                    <Route path="/readFeedback" component={ReadFeedback} />
                    <Route path="/checkBalance" component={CheckBalance} />
                    <Route path='/balanceAmount' component={BalanceAmount} />
                    <Route path='/ViewMarksOfStudents' component={ViewMarksOfStudents} />
                    <Route path='/ViewMarksheet' component={ViewMarksheet} />
                    <Route path="/ViewRanks" component={ViewRanks} />
                    <Route path="/ViewAttendance" component={ViewTeacherAttendance} />
                    <Route exact path='/home' component={Home} />
                </Switch>
            </BrowserRouter>
        </div>
    )
}

export default TeacherHome;