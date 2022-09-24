import { BrowserRouter, NavLink, Route, Switch, useHistory, useLocation } from 'react-router-dom'
import Login from '../Pages/Login';
import AdminProfile from '../Pages/Profiles/AdminProfile';
import MyProfile from '../Pages/Profiles/MyProfile';
import StudentProfile from '../Pages/Profiles/StudentProfile';
import TeacherProfile from '../Pages/Profiles/TeacherProfile';
import ActivateAccount from './Components/ActivateAccount';
import addClass from './Components/AddClass';
import AddSchedule from './Components/AddSchedule';
import AddSubject from './Components/AddSubject';
import EditSubject from './Components/SubComponents/EditSubject';
import AssignClassToStudents from './Components/AssignClassToStudents';
import AssignClassToTeachers from './Components/AssignClassToTeachers';
import AssignRole from './Components/AssignRole';
import CheckBalance from './Components/CheckBalance';
import EditStudentClass from './Components/EditStudentClass';
import EditUsers from './Components/EditUsers';
import FeeRecords from './Components/FeeRecords';
import PayTeacher from './Components/PayTeacher';
import ReadFeedback from './Components/ReadFeedback';
import Payment from './Components/SubComponents/Payment';
import ShowAmount from './Components/SubComponents/ShowAmount';
import TakeStudentAttendance from './Components/TakeStudentAttendance';
import TakeTeachersAttendance from './Components/TakeTeacherAttendance';
import ViewMarksheet from './Components/ViewMarksheet';
import ViewMarksOfStudents from './Components/ViewMarksOfStudents';
import ViewRanks from './Components/ViewRanks';
import ViewSchedule from './Components/ViewSchedule';
import ViewStudentAttendance from './Components/ViewStudentAttendance';
import ViewTeacherAttendance from './Components/ViewTeacherAttendance';
import './adminHome.css'
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '../../node_modules/bootstrap/dist/js/bootstrap.bundle'
import Home from '../home/Home';
import ViewAssignmentStudent from './Components/ViewAssignmentOfStudent';
import ViewAssignmentTeacher from './Components/ViewAssignmentTeacher';
import UserRegister from './Components/UserRegister';
const AdminHome = () => {

  const location = useLocation()
  const user = location.state

  const histroy = useHistory();
  const Logout = () => {
    histroy.push('/home')
  }
  return (
    <div>
      <BrowserRouter>
        <div className="container-fluid nav-bg">
          <div className="row">
            <div className="col-12 mx-auto">


              <nav className="navbar navbar-expand-lg navbar-light bg-dark">
                <div className="container-fluid">


                  <div className="collapse navbar-collapse" id="navbarNav">
                    <ul className="navbar-nav">
                      <li><NavLink className="nav-link adminHome" to={{ pathname: '/profile', aboutProps: { id: { user } } }}>My Profile</NavLink>
                      </li>

                      {/* <li>
                        <NavLink className="nav-link adminHome" to="/addClass">
                          Add Class
                        </NavLink>
                      </li> */}

                      <li>
                        <NavLink className="nav-link adminHome" to="/addUser">
                          Add User
                        </NavLink>
                      </li>
                      <li>
                        <NavLink className="nav-link adminHome" to="/addSubject">
                          Subjects
                        </NavLink>
                      </li>
                      <li className="nav-item dropdown">
                        <NavLink to="#" className="nav-link dropdown-toggle adminHome" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">User</NavLink>
                        <ul className="dropdown-menu">

                          <li className="nav-item">
                            <NavLink className="nav-link " to="/activateAccount">
                              Activate Account
                            </NavLink>
                          </li>
                          <li>
                            <NavLink className="nav-link " to="/editUsers">
                              Edit Users
                            </NavLink>
                          </li>


                        </ul>
                      </li>
                      <li className="nav-item dropdown">
                        <NavLink to="#" className="nav-link dropdown-toggle adminHome" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Assign</NavLink>
                        <ul className="dropdown-menu">
                          <li>
                            <NavLink className="nav-link " to="/AssignRole">
                              Role to Teacher
                            </NavLink>
                          </li>
                          <li>
                            <NavLink className="nav-link " to="/AssignClassToTeachers">
                              Subjects to Teachers
                            </NavLink>
                          </li>

                          <li>
                            <NavLink className="nav-link " to="/AssignClassToStudents">
                              Classes to Students
                            </NavLink>
                          </li>


                        </ul>
                      </li>
                      <li className="nav-item dropdown">
                        <NavLink to="#" className="nav-link dropdown-toggle adminHome" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">View</NavLink>
                        <ul className="dropdown-menu">
                          <li>
                            <NavLink className="nav-link" to="/viewSchedule">
                              Schedule
                            </NavLink>
                          </li>
                          <li>
                            <NavLink className="nav-link " to="/viewMarksOfStudents">
                              Marks
                            </NavLink>
                          </li>
                          <li>
                            <NavLink className="nav-link" to="/viewMarksheets">
                              Marksheets
                            </NavLink>
                          </li>
                          <li>
                            <NavLink className="nav-link " to="/viewRanks">
                              Ranks
                            </NavLink>
                          </li>
                          <li>
                            <NavLink className="nav-link " to="/viewTeacherAttendance">
                              Teacher Attendance
                            </NavLink>
                          </li>

                          <li>
                            <NavLink className="nav-link " to="/viewStudentAttendance">
                              Student Attendance
                            </NavLink>
                          </li>
                          <li>
                            <NavLink className="nav-link" to="/viewAssignmentTeacher">
                              Assignment Posted
                            </NavLink>
                          </li>
                          <li>
                            <NavLink className="nav-link" to="/viewAssignmentStudent">
                              Assignment Submitted
                            </NavLink>
                          </li>

                        </ul>
                      </li>

                      <li>
                        <NavLink className="nav-link adminHome" to="/AddSchedule">
                          Add Schedule
                        </NavLink>
                      </li>
                      <li className="nav-item dropdown">
                        <NavLink to="#" className="nav-link dropdown-toggle adminHome" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Attendance</NavLink>
                        <ul className="dropdown-menu">

                          <li>
                            <NavLink className="nav-link " to="/takeStudentsAttendance">
                              Students
                            </NavLink>
                          </li>

                          <li>
                            <NavLink className="nav-link " to="/takeTeachersAttendance">
                              Teachers
                            </NavLink>
                          </li>


                        </ul>
                      </li>

                      <li>
                        <NavLink className="nav-link adminHome" to="/readFeedbacks">
                          Feedbacks
                        </NavLink>
                      </li>
                      <li className="nav-item dropdown">
                        <NavLink to="#" className="nav-link dropdown-toggle adminHome" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Finance</NavLink>
                        <ul className="dropdown-menu">

                          <li>
                            <NavLink className="nav-link " to="/PayTeacher">
                              Pay Teacher
                            </NavLink>
                          </li>
                          <li>
                            <NavLink className="nav-link " to="/feeRecords">
                              Fee Records
                            </NavLink>
                          </li>



                          <li>
                            <NavLink className="nav-link " to={{
                              pathname: '/checkBalance',
                              aboutProps: {
                                id: { user }
                              }
                            }

                            }>Check Balance</NavLink>
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
                        <a className="adminHome">ADMIN</a>
                      </li>

                    </ul>

                  </div>
                </div>
              </nav>

            </div>
          </div>
        </div>





        <Switch>
          <Route exact path='/home' component={Home} />
          <Route path='/activateAccount' component={ActivateAccount} />
          <Route path='/Logout' component={Login} />
          <Route path='/editUsers' component={EditUsers} />
          <Route path='/studentProfile' component={StudentProfile} />
          <Route path='/teacherProfile' component={TeacherProfile} />
          <Route path='/profile' component={MyProfile} />
          <Route path='/adminProfile' component={AdminProfile} />
          <Route path='/addClass' component={addClass} />
          <Route path='/addUser' component={UserRegister} />
          <Route path='/addSubject' component={AddSubject} />
          <Route path='/editSubject' component={EditSubject} />

          <Route path='/AssignRole' component={AssignRole} />
          <Route path='/AssignClassToTeachers' component={AssignClassToTeachers} />
          <Route path="/AssignClassToStudents" component={AssignClassToStudents} />
          <Route path='/EditStudentClass' component={EditStudentClass} />
          <Route path='/AddSchedule' component={AddSchedule} />
          <Route path='/viewSchedule' component={ViewSchedule} />
          <Route path='/takeStudentsAttendance' component={TakeStudentAttendance} />
          <Route path='/takeTeachersAttendance' component={TakeTeachersAttendance} />
          <Route path="/readFeedbacks" component={ReadFeedback} />
          <Route path='/checkBalance' component={CheckBalance} />
          <Route path='/showAmount' component={ShowAmount} />
          <Route path='/PayTeacher' component={PayTeacher} />
          <Route path='/Payment' component={Payment} />
          <Route path="/feeRecords" component={FeeRecords} />
          <Route path="/viewMarksOfStudents" component={ViewMarksOfStudents} />
          <Route path='/viewMarksheets' component={ViewMarksheet} />
          <Route path="/viewRanks" component={ViewRanks} />
          <Route path="/viewTeacherAttendance" component={ViewTeacherAttendance} />
          <Route path="/viewStudentAttendance" component={ViewStudentAttendance} />

          <Route path="/viewAssignmentStudent" component={ViewAssignmentStudent} />
          <Route path="/viewAssignmentTeacher" component={ViewAssignmentTeacher} />
        </Switch>

      </BrowserRouter>
    </div>
  )
}

export default AdminHome;