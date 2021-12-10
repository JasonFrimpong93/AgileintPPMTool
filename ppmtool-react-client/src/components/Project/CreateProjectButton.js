import React from "react";
import { Link } from "react-router-dom";
const CreateProjectButton = () => {
  return (
    //react frag no div to worry about but is wrapped around parent component
    //link is replacement for a href in react router dom
    <React.Fragment>
      <Link to="/addProject" className="btn btn-lg btn-info">
        Create a Project
      </Link>
    </React.Fragment>
  );
};

export default CreateProjectButton;
