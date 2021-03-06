/*
 * Copyright 2010-2019 Australian Signals Directorate
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
package au.gov.asd.tac.constellation.arrangements.uncollide.d3;

/**
 *
 * @author algol
 */
public class BoundingBox3D {

    public static Box3D getBox(final Orb3D[] orbs) {
        final Orb3D orb0 = orbs[0];
        float minx = orb0.x;
        float miny = orb0.y;
        float minz = orb0.z;
        float maxx = minx;
        float maxy = miny;
        float maxz = minz;

        for (final Orb3D orb : orbs) {
            final float x = orb.x;
            final float y = orb.y;
            final float z = orb.z;
            if (x < minx) {
                minx = x;
            }
            if (x > maxx) {
                maxx = x;
            }
            if (y < miny) {
                miny = y;
            }
            if (y > maxy) {
                maxy = y;
            }
            if (z < minz) {
                minz = z;
            }
            if (z > maxz) {
                maxz = z;
            }
        }

        return new Box3D(minx, miny, minz, maxx, maxy, maxz);
    }

    public static class Box3D {

        public final float minx;
        public final float miny;
        public final float minz;
        public final float maxx;
        public final float maxy;
        public final float maxz;

        public Box3D(final float minx, final float miny, final float minz, final float maxx, final float maxy, final float maxz) {
            this.minx = minx;
            this.miny = miny;
            this.minz = minz;
            this.maxx = maxx;
            this.maxy = maxy;
            this.maxz = maxz;
        }

        @Override
        public String toString() {
            return String.format("[Box3D %f %f %f %f %f %f]", minx, miny, minz, maxx, maxy, maxz);
        }
    }
}
