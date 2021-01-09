import './styles.css';
import { ReactComponent as LinkedinIcon } from './linkedin.svg';

function Footer() {
    return (
       <footer className="main-footer">
           App develop by Edson Costa
           <div className="footer-icons">
               <a href="https://www.linkedin.com/in/edsonmcosta" target="_new">
                <LinkedinIcon />
               </a>
           </div>
       </footer>
    )
}

export default Footer;