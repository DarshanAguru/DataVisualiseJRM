import './Dashboard.css';

import Chart from 'chart.js/auto';
import { CategoryScale } from 'chart.js';
import CvsPonEY from './CvsPonEY';
import EYvsP from './EYvsP';
import TvsP from './TvsP';
import SvsI from './SvsI';

Chart.register(CategoryScale);



export default function Dashboard() {
    

    return (
        <div className='dashboard-container'>
            <CvsPonEY/>
            <EYvsP/>
            <TvsP/>
            <SvsI/>
        </div>
    );
}
