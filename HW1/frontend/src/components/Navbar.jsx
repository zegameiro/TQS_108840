import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <div className="navbar bg-base-100">
      <div className="flex-1">
        <Link to="/homepage" className="btn btn-ghost text-xl">BusWise</Link>
      </div>
    </div>
  );
};

export default Navbar;
