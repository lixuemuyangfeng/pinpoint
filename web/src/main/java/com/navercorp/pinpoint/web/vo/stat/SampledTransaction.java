/*
 * Copyright 2016 Naver Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.navercorp.pinpoint.web.vo.stat;

import com.navercorp.pinpoint.web.vo.chart.Point;
import com.navercorp.pinpoint.web.vo.stat.chart.agent.AgentStatPoint;

import java.util.Objects;

/**
 * @author HyunGil Jeong
 */
public class SampledTransaction implements SampledAgentStatDataPoint {

    public static final double UNCOLLECTED_VALUE = -1D;
    public static final Point.UncollectedPointCreator<AgentStatPoint<Double>> UNCOLLECTED_POINT_CREATOR = new Point.UncollectedPointCreator<AgentStatPoint<Double>>() {
        @Override
        public AgentStatPoint<Double> createUnCollectedPoint(long xVal) {
            return new AgentStatPoint<>(xVal, UNCOLLECTED_VALUE);
        }
    };

    private final AgentStatPoint<Double> sampledNew;
    private final AgentStatPoint<Double> sampledContinuation;
    private final AgentStatPoint<Double> unsampledNew;
    private final AgentStatPoint<Double> unsampledContinuation;
    private final AgentStatPoint<Double> total;

    public SampledTransaction(AgentStatPoint<Double> sampledNew, AgentStatPoint<Double> sampledContinuation, AgentStatPoint<Double> unsampledNew, AgentStatPoint<Double> unsampledContinuation, AgentStatPoint<Double> total) {
        this.sampledNew = Objects.requireNonNull(sampledNew, "sampledNew must not be null");
        this.sampledContinuation = Objects.requireNonNull(sampledContinuation, "sampledContinuation must not be null");
        this.unsampledNew = Objects.requireNonNull(unsampledNew, "unsampledNew must not be null");
        this.unsampledContinuation = Objects.requireNonNull(unsampledContinuation, "unsampledContinuation must not be null");
        this.total = Objects.requireNonNull(total, "total must not be null");
    }

    public AgentStatPoint<Double> getSampledNew() {
        return sampledNew;
    }



    public AgentStatPoint<Double> getSampledContinuation() {
        return sampledContinuation;
    }


    public AgentStatPoint<Double> getUnsampledNew() {
        return unsampledNew;
    }


    public AgentStatPoint<Double> getUnsampledContinuation() {
        return unsampledContinuation;
    }


    public AgentStatPoint<Double> getTotal() {
        return total;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SampledTransaction that = (SampledTransaction) o;

        if (sampledNew != null ? !sampledNew.equals(that.sampledNew) : that.sampledNew != null) return false;
        if (sampledContinuation != null ? !sampledContinuation.equals(that.sampledContinuation) : that.sampledContinuation != null)
            return false;
        if (unsampledNew != null ? !unsampledNew.equals(that.unsampledNew) : that.unsampledNew != null) return false;
        if (unsampledContinuation != null ? !unsampledContinuation.equals(that.unsampledContinuation) : that.unsampledContinuation != null)
            return false;
        return total != null ? total.equals(that.total) : that.total == null;
    }

    @Override
    public int hashCode() {
        int result = sampledNew != null ? sampledNew.hashCode() : 0;
        result = 31 * result + (sampledContinuation != null ? sampledContinuation.hashCode() : 0);
        result = 31 * result + (unsampledNew != null ? unsampledNew.hashCode() : 0);
        result = 31 * result + (unsampledContinuation != null ? unsampledContinuation.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SampledTransaction{");
        sb.append("sampledNew=").append(sampledNew);
        sb.append(", sampledContinuation=").append(sampledContinuation);
        sb.append(", unsampledNew=").append(unsampledNew);
        sb.append(", unsampledContinuation=").append(unsampledContinuation);
        sb.append(", total=").append(total);
        sb.append('}');
        return sb.toString();
    }
}
